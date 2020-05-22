package com.asd;

import java.net.URL;

public class Main {

    public static void main(String[] args) {
        Class aClass = YouClas.class;
        String classResource = Timestamp.class.getName().replace(".", "/")+".class";
        System.out.println(classResource);
        URL url  =aClass.getClassLoader().getResource(classResource);
        System.out.println(url);
    }
}