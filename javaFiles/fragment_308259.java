LoggerContext context = (LoggerContext)LoggerFactory.getILoggerFactory();
for (Logger logger : context.getLoggerList()) {
        for (Iterator<Appender<ILoggingEvent>> index = logger.iteratorForAppenders(); index.hasNext();) {
            Appender<ILoggingEvent> appender = index.next();
        }
    }