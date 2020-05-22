public void checkForLog4jConfigFile() {

org.apache.log4j.Logger rootLogger = org.apache.log4j.Logger.getRootLogger();
Enumeration appenders = rootLogger.getAllAppenders();
if (!appenders.hasMoreElements()) {
    System.out.println("LOG4J config file is missing");
} else {
    System.out.println("appender found "
    + ((Appender) appenders.nextElement()).getName());
}
}