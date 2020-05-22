Enumeration allAppenders = Logger.getRootLogger().getAllAppenders();
while (allAppenders.hasMoreElements()) {
    Object object = (Object) allAppenders.nextElement();
    if (object instanceof RollingFileAppender) {
        RollingFileAppender appender = (RollingFileAppender) object;
        appender.setFile("/path/to/new/file.log");
        appender.activateOptions();
        break;
    }
}