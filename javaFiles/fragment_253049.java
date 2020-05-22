package com.tutorial;

import org.springframework.aop.framework.Advised;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Application {
  public static void main(String[] args) throws Exception {
    try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aop.xml")) {
      Gson gson = new GsonBuilder().setPrettyPrinting().create();
      Student student = (Student) context.getBean("student");
      System.out.println(gson.toJson(unProxy(student)));
    }
 }

  public static Object unProxy(Object object) throws Exception {
    return object instanceof Advised
      ? ((Advised) object).getTargetSource().getTarget()
      : object;
  }
}