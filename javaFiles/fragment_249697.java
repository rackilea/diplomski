public class SleepThread extends Thread {
  public static void main(String args[]) {
    Thread t = new SleepThread();
    t.start();
    System.err.println("Main thread exiting.");
  }

  @Override
  public void run() {
    System.err.println("Thread running.");
    try {
      Thread.sleep(5 * 1000); // 5 seconds
    } catch (InterruptedException ie) {
      System.err.println("INTERRUPTED");
    }
    System.err.println("Thread exiting.");
  }
}