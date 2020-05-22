private static final String FQCN = Logger.class.getName();


public static void debug(String clazz, String message) {
    org.slf4j.Logger logger = LoggerFactory.getLogger(clazz);
    if (logger instanceof LocationAwareLogger) {
        ((LocationAwareLogger) logger).log(null, FQCN, LocationAwareLogger.DEBUG_INT, message, null, null);
    } else {
        logger.debug(message);
    }
}