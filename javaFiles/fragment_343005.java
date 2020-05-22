package com.test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Test {
  public static void main(String[] args) {
    ClassPathXmlApplicationContext context = new 
           ClassPathXmlApplicationContext("/com/test/appConfig.xml");
    Integer someIntBean = (Integer) context.getBean("testBean");
    System.out.println(someIntBean.intValue()); // prints 100, as you will see later
  }
}