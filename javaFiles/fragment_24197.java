public class ReScheduler {
  private ScheduledFuture<?> currentTask = null;
  private static final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
  public void schedule(Runnable command, long delay, TimeUnit units) {
    if (currentTask != null) {
       currentTask.cancel();
       currentTask = null;
    }
    currentTask = executor.schedule(command, delay, units);
  }
}