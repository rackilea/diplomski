package com.tutorial;

import org.springframework.aop.TargetSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Application {
  public static void main(String[] args) throws Exception {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");

    Student student = (Student) context.getBean("student");
    TargetSource targetSource = (TargetSource)
      student
        .getClass()
        .getMethod("getTargetSource", null)
        .invoke(student, null);
    System.out.println(gson.toJson(targetSource.getTarget()));
 }
}