package com.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author dhubau
 */
public class LogTest {

    private static final Logger logger = LoggerFactory.getLogger(LogTest.class.getCanonicalName());

    @Test
    public void testLogs() throws IOException {
        logger.trace("BEFORE");
        logger.debug("BEFORE");
        logger.info("BEFORE");
        logger.warn("BEFORE");
        logger.error("BEFORE");

        InputStream is = LogTest.class.getResourceAsStream("/logging.properties");

        LogManager.getLogManager().readConfiguration(is);

        logger.trace("AFTER");
        logger.debug("AFTER");
        logger.info("AFTER");
        logger.warn("AFTER");
        logger.error("AFTER");
    }
}