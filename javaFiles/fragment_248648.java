// Client code
for (Task task : tasks) {
  task.stop();
}

// Threading code
public abstract class Task implements Runnable {

  private volatile boolean stopped = false;

  public void stop() {
    stopped = true;
  }

  protected boolean shouldStop() {
    return stopped;
  }

  public abstract void run();
}