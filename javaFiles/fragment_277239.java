package com.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2Tester {
    private static final Logger LOG = LogManager.getLogger(Log4j2Tester.class);

    public static void main(String[] args) {
        LOG.error("testing ERROR level");

//if you change the level of root logger to 'trace'
//then you'll also see something like
//    13:27:50.244 [main] TRACE com.example.Log4j2Tester - exiting application
        LOG.trace("exiting application");
    }
}