public class Main {
  /**
   * Delay in milliseconds until finished.
   */
  private static final long FINISH_BY = 10000;
  /**
   * Start with this number.
   */
  private static final int START_WITH = 1;
  /**
   * Delay between eversquare passes in milliseconds.
   */
  private static final long DELAY_BETWEEN_PASSES = 50;
  /**
   * Holds the current result. The "volatile" keyword tells the JVM that the
   * value could be changed by another thread, so don't cache it. Marking a
   * variable as volatile incurs a *serious* performance hit so don't use it
   * unless really necessary.
   */
  private static volatile int currentResult = 0;

  public static void main(String[] args) {
    // create a Thread to run "eversquare" in parallel
    Thread eversquareThread = new Thread(new Runnable() {
      @Override public void run() {
        eversquare(START_WITH, DELAY_BETWEEN_PASSES);
      }
    });

    // make the eversquare thread shut down when the "main" method exits
    // (otherwise the program would never finish, since the "eversquare" thread
    // would run forever due to its "while" loop)
    eversquareThread.setDaemon(true);

    // start the eversquare thread
    eversquareThread.start();

    // wait until the specified delay is up
    long currentTime = System.currentTimeMillis();
    final long stopTime = currentTime + FINISH_BY;
    while (currentTime < stopTime) {
      final long sleepTime = stopTime - currentTime;
      try {
        Thread.sleep(sleepTime);
      } catch (InterruptedException ex) {
        // in the unlikely event of an InterruptedException, do nothing since
        // the "while" loop will continue until done anyway
      }
      currentTime = System.currentTimeMillis();
    }
    System.out.println(currentResult);
  }

  /**
   * Increment the value and compute its square. Runs forever if left to its own
   * devices.
   *
   * @param startValue
   * The value to start with.
   *
   * @param delay
   * If you were to try to run this without any delay between passes, it would
   * max out the CPU and starve any other threads. This value is the wait time
   * between passes.
   */
  private static void eversquare(final int startValue, final long delay) {
    int currentValue = startValue;
    while (true) { // run forever (just use "true"; "2==2" looks silly)
      currentResult = square(currentValue); // store in the global "currentResult"
      currentValue++; // even shorter than "x += 1"
      if (delay > 0) {
        try { // need to handle the exception that "Thread.sleep()" can throw
          Thread.sleep(delay);
        } catch (InterruptedException ex) { // "Thread.sleep()" can throw this
          // just print to the console in the unlikely event of an
          // InterruptedException--things will continue fine
          ex.printStackTrace();
        }
      }
    }
  }

  private static int square(int x) {
    return x * x;
  }
}