package com.junlaninfo;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TestSessionController {

	// 创建session 会话
    @RequestMapping("/createSession")
	public String createSession(HttpServletRequest request, String nameValue) {
		HttpSession session = request.getSession(false);
		String id = session.getId();
		System.out.println("存入Session  sessionid:信息" + session.getId() + ",nameValue:" + nameValue);
		session.setAttribute("name", nameValue);
		return "success";
	}

	// 获取session 会话
	@RequestMapping("/getSession")
	public Object getSession(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		String id = session.getId();
		System.out.println("获取Session sessionid:信息" + session.getId());
		Object value = session.getAttribute("name");
		return value;
	}

	public static void main(String[] args) {
		SpringApplication.run(TestSessionController.class, args);
	}
}