ExecutorService service=Executors.newFixedThreadPool(1);
Future<?> f=service.submit(new Runnable() {
  public void run() {
    try {
      while(conditionFalse()) {
        System.out.println("it’s false, will wait");
        Thread.sleep(TimeUnit.SECONDS.toMillis(2));
      }
      System.out.println("true. exiting.");
    } catch(InterruptedException ex) {
      System.out.println("interrupted. exiting.");
    }
  }
});
try {
  try {
    f.get(5, TimeUnit.SECONDS);
    System.out.println("conditions met even before trying to cancel");
  } catch(TimeoutException ex) {
    System.out.println("canceling");
    System.out.println(f.cancel(true)?
      "canceled before conditions met": "conditions met before canceled");
  }
} catch(InterruptedException | ExecutionException ex) {
  throw new AssertionError(ex);
}