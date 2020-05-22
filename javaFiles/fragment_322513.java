package org.foo.bar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
        MyClass myObj = context.getBean("myObj", MyClass.class);

        System.out.println(myObj);
        System.out.println(myObj.getValue1());
        System.out.println(myObj.getValue2());
    }

}