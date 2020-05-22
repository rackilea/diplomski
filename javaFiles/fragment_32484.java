package de.scrum_master.aspect;

import java.io.File;

public aspect FileInterceptor {
    Object around(String fileName): call(File+.new(String)) && args(fileName) {
        System.out.println(thisJoinPoint + " -> " + fileName);
        return proceed(fileName);
    }

    void around(String fileName): execution(File+.new(String))  && args(fileName) {
        System.out.println(thisJoinPoint + " -> " + fileName);
        proceed(fileName);
    }
}