public class Main {
  private final Object lockA = new Object();
  private final Object lockB = new Object();

  public static void main(String[] args) {
    new Main();
  }

  public Main() {
    new Thread(new Runnable() {
      public void run() {
        a();
        sleep(3000L); // Add a delay here to increase chance of deadlock.
        b();
      }
    }, "Thread-A").start();

    new Thread(new Runnable() {
      public void run() {
        // Note: Second thread acquires locks in the reverse order of the first!
        b();
        sleep(3000L); // Add a delay here to increase chance of deadlock.
        a();
      }
    }, "Thread-A").start();
  }

  private void a() {
    log("Trying to acquire lock A.");

    synchronized(lockA) {
      log("Acquired lock A.");
    }
  }

  private void b() {
    log("Trying to acquire lock B.");

    synchronized(lockB) {
      log("Acquired lock B.");
    }
  }

  private void sleep(long millis) {
    try {
      Thread.sleep(millis);
    } catch(InterruptedException ex) {
    }
  }

  private void log(String msg) {
    System.err.println(String.format("Thread: %s, Message: %s",
      Thread.currentThread().getName(), msg));
  }
}