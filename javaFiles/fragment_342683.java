package com.vkg;

import org.apache.log4j.Logger;

public class TestLogs {
    private static Logger logger = Logger.getLogger(TestLogs.class.getName());

    public static void main(String[] args) {
        logger.info("It works");
        TestLogs tls = new TestLogs();
    }
}