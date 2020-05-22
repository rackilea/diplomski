final Thread.UncaughtExceptionHandler defaultHandler = 
    Thread.getDefaultUncaughtExceptionHandler();
Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        doCustomHandlingHere();
        defaultHandler.uncaughtException(t,e);
    }
});