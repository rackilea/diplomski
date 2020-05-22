Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
  public void uncaughtException(Thread t, Throwable e) {
    System.out.println("Handled exception - let's log it!");
    // Logging code here
  }
});