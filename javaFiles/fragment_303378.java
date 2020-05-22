private static void setDefaultUncaughtExceptionHandler() {
    try {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                LOGGER.error("Uncaught Exception detected in thread " + t, e);
            }
        });
    } catch (SecurityException e) {
        LOGGER.error("Could not set the Default Uncaught Exception Handler", e);
    }
}