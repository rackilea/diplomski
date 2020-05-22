public void log(Level level, Supplier<String> msgSupplier) {
    if (!isLoggable(level)) {
        return;
    }
    LogRecord lr = new LogRecord(level, msgSupplier.get()); // <-- here is the expensive computation
    doLog(lr);
}