package com.daniel.logger;
import org.apache.log4j.Logger;

import com.daniel.package1.ClassA;
import com.daniel.package2.ClassB;

public class MyLogger{

    public static void write(String message, Class<?> clazz){
        Logger.getLogger(clazz).info(message);
    }

    public static void main(String[] args){
        ClassA.log();
        ClassB.log();
    }
}