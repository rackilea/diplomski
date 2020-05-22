package org.somepackgs;
import org.apache.log4j.Logger;

public class FinalLogger {
    private static Logger logger = Logger.getLogger(FinalLogger.class);

    public static void logInfo(String message) {
        logger.info(message);
    }
}