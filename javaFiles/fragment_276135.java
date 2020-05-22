class Reader extends Thread {
  Calculator c;

  public Reader(Calculator calc) {
    c = calc;
  }

  public void run() {
    synchronized (c) {
      try {
        System.out.println("Waiting for calculation...");

        if (!c.isCalculated) { // wait only if calculation is not done
          c.wait();
        }
      } catch (InterruptedException e) {
      }
      System.out.println("Total is: " + c.total);
    }
  }
}

class Calculator implements Runnable {
  int total;
  boolean isCalculated;

  public void run() {
    synchronized (this) {
      for (int i = 0; i < 100; i++) {
        total += i;
      }

      isCalculated = true;  // set flag to mark that computation is complete
      notifyAll();
    }
  }
}