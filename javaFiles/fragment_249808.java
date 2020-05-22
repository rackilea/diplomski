public static void rerouteAppenderToFile(File file, Logger... log) {
    RollingFileAppender fa = createAppender(file);
    for (Logger logger : log) {
        rerouteAppenderToFile(f, logger);
    }
}

public static Appender createAppender(File file) {
    RollingFileAppender fa = new RollingFileAppender();
    fa.setName("RollingFileAppender_" + log.getName());
    fa.setMaxBackupIndex(3);
    fa.setMaxFileSize("20MB");
    File folder = file.getParentFile();
    folder.mkdirs();
    fa.setFile(file.getAbsolutePath());
    fa.setLayout(new PatternLayout(LOGGER_PATTERN));
    fa.setThreshold(Level.DEBUG);
    fa.setAppend(true);
    fa.activateOptions();
    return fa;
}

public static void rerouteAppenderToFile(Appender fa, Logger log) {
    log.setAdditivity(false);
    log.setLevel(Level.DEBUG);
    log.addAppender(fa);
}