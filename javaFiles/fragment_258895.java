Thread thread = new Thread(...);
 final AtomicReference throwableReference = new AtomicReference<Throwable>();
 thread.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
     public void uncaughtException(Thread t, Throwable e) {
         throwableReference.set(e);
     }
 });
 thread.start();
 thread.join();
 Throwable throwable = throwableReference.get();
 if (throwable != null) {
     if (throwable instanceof OhNoException) {
        throw (OhNoException)throwable;
     } else if (throwable instanceof RuntimeException) {
        throw (RuntimeException)throwable;
     }
 }