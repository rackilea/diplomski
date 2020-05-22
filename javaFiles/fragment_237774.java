package com.daniel.package1;

import com.daniel.logger.MyLogger;

public class ClassA {

    public static void log(){
        MyLogger.write("ClassA",ClassA.class);
    }
}