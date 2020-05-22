private final ScheduledExecutorService scheduler =
    Executors.newSingleThreadScheduledExecutor();

private Future<?> timingTask;

public void tick(long milliseconds) {
  timingTask = scheduler.scheduleAtFixedRate(new Runnable() {
    public void run() {
      System.out.println("sec"+sequencer.getMicrosecondPosition()/1000000);
    }
  }, 0, milliseconds, TimeUnit.MILLISECONDS);
}