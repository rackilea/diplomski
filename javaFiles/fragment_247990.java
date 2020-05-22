// (Need to make variable final *if* it is a local (method) variable.)
final ScheduledExecutorService execService = Executors.newSingleThreadScheduledExecutor();

// Create re-usable Callable.  In cases where the Callable has state
// we may need to create a new instance each time depending on requirements.
Callable<Void> task = new Callable() {
  public Void call() {
    try {
      doSomeProcessing();
    } finally {
      // Schedule same task to run again (even if processing fails).
      execService.schedule(this, 1, TimeUnit.SECONDS);
    }
  }
}