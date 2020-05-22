Thread.UncaughtExceptionHandler h = new Thread.UncaughtExceptionHandler() {
    public void uncaughtException(Thread th, Throwable ex) {
       Log.e("TEST","Uncaught exception: " + ex);
    }
};
final Thread thread = new Thread() {
    public void run() {
        Log.d("TEST","Performing action...");
        throw new RuntimeException("Exception from thread");
    }
};
thread.setUncaughtExceptionHandler(h);
thread.start();