public class Main {
  // Non-volatile integer "result".
  private int i;

  public static void main(String[] args) {
    new Main();
  } 

  public Main() {
    Thread t1 = new Thread(new Runnable() {
      public void run() {
        countUp();
      }
    }, "Thread-1");

    Thread t2 = new Thread(new Runnable() {
      public void run() {
        countDown();
      }
    }, "Thread-2");

    t1.start();
    t2.start();

    // Wait for two threads to complete.
    t1.join();
    t2.join();

    // Print out result.  With correct concurrency control we expect the result to
    // be 0.  A non-zero result indicates incorrect use of concurrency.  Also note
    // that the result may vary between runs because of this.
    System.err.println("i: " + i);
  }

  private void countUp() {
    // Increment instance variable i 1000,000 times.  The variable is not marked
    // as volatile, nor is it accessed within a synchronized block and hence
    // there is no guarantee that the value of i will be reconciled back to main
    // memory following the increment.
    for (int j=0; j<1000000; ++j) {
      ++i;
    }
  }

  private void countDown() {
    // Decrement instance variable i 1000,000 times.  Same consistency problems
    // as mentioned above.
    for (int j=0; j<1000000; ++j) {
      --i;
    }
  }
}