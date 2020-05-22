Enumeration<String> loggers = LogManager.getLogManager().getLoggerNames();
    while (loggers.hasMoreElements()) {
        String loggerName = loggers.nextElement();
        if(loggerName.contains("glassfish")) {
            Logger logger = LogManager.getLogManager().getLogger(loggerName);
            logger.setLevel(Level.OFF);     
        }
    }