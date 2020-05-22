String[] modules = new String[] {"module1", "module2", "module3"};
Logger baseLogger = Logger.getLogger("com.package.module.base");
DailyRollingFileAppender baseAppender = (DailyRollingFileAppender) baseLogger.getAppender("baseModuleAppender");

for (String module : modules) {
    Logger logger = Logger.getLogger("com.package." + module);
    logger.setLevel(baseLogger.getLevel());
    logger.setAdditivity(baseLogger.getAdditivity());

    String filename = baseAppender.getFile().replaceAll("\\$\\{module}", module);
    DailyRollingFileAppender appender = new DailyRollingFileAppender(baseAppender.getLayout(), filename, baseAppender.getDatePattern());
    appender.setAppend(baseAppender.getAppend());
    appender.setThreshold(baseAppender.getThreshold());
    logger.addAppender(appender);
}