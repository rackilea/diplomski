FileAppender appender = new FileAppender();
// configure the appender here, with file location, etc
appender.activateOptions();

Logger logger = getRootLogger();
logger.addAppender(appender);