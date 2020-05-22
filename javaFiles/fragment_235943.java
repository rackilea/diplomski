try {
   .... 
   // invoke main method
} catch (Exception e) {
  Thread currentThread = Thread.currentThread();
  Thread.UncaughtExceptionHandler ueh = currentThread.getUncaughtExceptionHandler();
  if (ueh == null) {
    currentThread.getThreadGroup().uncaughtException(currentThread, e);
  } else {
    ueh.uncaughtException(currentThread, e);
  }
}