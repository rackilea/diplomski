package com.someco;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.someco.AnyInterface;

public class ProxyTester {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("better-application-context.xml"); 
        AnyInterface tester = (AnyInterface) context.getBean("goodbyeProxy");
        tester.sayHello();
    }
}