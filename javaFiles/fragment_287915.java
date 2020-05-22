public int println(int priority, String msg) {
    Throwable t = new Throwable();
    StackTraceElement[] stackTrace = t.getStackTrace();

    // Optional: translate from Android log levels to GAE log levels.
    final Level[] levels = { Level.FINEST, Level.FINER, Level.FINE, Level.CONFIG,Level.INFO, Level.WARNING, Level.SEVERE, Level.SEVERE };
    Level level = levels[priority];

    LogRecord lr = new LogRecord(level, msg);
    if (stackTrace.length > 2) { // should always be true
        lr.setSourceClassName(stackTrace[2].getClassName());
        lr.setSourceMethodName(stackTrace[2].getMethodName());
    }
    log.log(lr);
    return 0;
}