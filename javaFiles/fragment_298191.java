public static Logger getPackageLogger(String packageName) {
    Logger logger = Logger.getLogger(packageName);
    if (logger.getAppender("myPackageAppender") == null) {
        String logFileName = packageName + ".log"; // or something
        SimpleLayout layout = new SimpleLayout();
        FileAppender appender = new FileAppender(
            layout, logFileName, true);    
        appender.setName("myPackageAppender");
        logger.setAdditivity(false);
        logger.addAppender(appender);
    }
    return logger;
}