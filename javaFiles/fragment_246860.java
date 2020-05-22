ScheduledExecutorService service = executors.newSingleThreadScheduledExecutor();
service.scheduleAtFixedRate(new Runnable() {
  public void run() {
    // do one iteration of your work
    ScreenRecorder.capture(...);
    ...
  }
}, 0L, 33L, TimeUnit.MILLISECONDS);

...
service.shutdown(); // to stop