public class SequentialExecution implements Runnable {

  private int i = 1;

  public void run() {

    String tmp = Thread.currentThread().getName();

    if (tmp.equals("first")) {
      synchronized (this) {
        first();
        i = 2;
      }
    } else if (tmp.equals("second")) {
      while (true) {
        synchronized (this) {
          if (i == 2) {
            break;
          }
        }
      }
      synchronized (this) {
        second();
        i = 3;
      }
    } else {
      while (true) {
        synchronized (this) {
          if (i == 3) {
            break;
          }
        }
      }

      synchronized (this) {
        third();
      }
    }

  }

  public void first() {
    System.out.println("first " + i);
  }

  public void second() {
    System.out.println("second " + i);
  }

  public void third() {
    System.out.println("third " + i);
  }

  public static void main(String[] args) throws InterruptedException {
    // create 3 threads and call first(), second() and third() sequentially
    for (int i = 0; i < 1000; i++) {
      SequentialExecution se = new SequentialExecution();
      Thread t1 = new Thread(se, "first");
      Thread t2 = new Thread(se, "second");
      Thread t3 = new Thread(se, "third");

      t3.start();
      t2.start();
      t1.start();
      t1.join();
      t2.join();
      t3.join();
    }

  }
}