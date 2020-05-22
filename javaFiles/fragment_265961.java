public static void main(String[] args) throws Exception {
    final String format = "%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS %4$s %2$s %5$s%6$s%n";
    final String key = "java.util.logging.SimpleFormatter.format";
    test(format);
    test(System.getProperty(key, format));
    test(LogManager.getLogManager().getProperty(key));
    test(new SimpleFormatter());
}

private static void test(Formatter f) {
    LogRecord record = newLogRecord();
    System.out.println(f.format(record));
}

private static LogRecord newLogRecord() {
    LogRecord r = new LogRecord(Level.INFO, "Message");
    r.setSourceClassName("sourceClassName");
    r.setSourceMethodName("sourceMethodName");
    r.setLoggerName("loggerName");
    return r;
}

private static void test(String format) {
    if (format != null) {
        LogRecord record = newLogRecord();
        Throwable t = record.getThrown();
        System.out.println(String.format(format,
                new java.util.Date(record.getMillis()),
                record.getSourceClassName(),
                record.getLoggerName(),
                record.getLevel().getLocalizedName(),
                record.getMessage(),
                t != null ? t.toString() : ""));
        //TODO: Place printStackTrace into a string.
    } else {
        System.out.println("Format is null.");
    }
}