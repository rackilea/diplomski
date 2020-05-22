package com.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    static ListAppender listAppender = new ListAppender();

    public static void main(String[] args) {
        logger.info("Hello World");
        listAppender.getEventList().forEach(entry -> System.out.println("print log from list:" + entry));
        System.out.println();
    }
}