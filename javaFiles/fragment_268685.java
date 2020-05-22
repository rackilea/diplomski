public class SyncObj {
  private volatile int i;
  private BlockingQueue<Integer> q = new LinkedBlockingQueue<Integer>();
  public synchronized void inc() {
    if (i < 8) {
      i++;
      q.add(i);
    }
  }
  public synchronized void dec() {
    if (i > 0) {
      i--;
      q.add(i);
    }
  }
  public void print() {
    for (Integer i = q.poll(); i != null; i = q.poll()) {
      System.out.print(i);
    }
  }
  private static volatile boolean stop = false;
  public static void main(String[] args) throws InterruptedException {
    final SyncObj o = new SyncObj();

    new Thread(new Runnable() {
      @Override
      public void run() {
        while (!stop) {
          o.inc();
        }
      }
    }).start();

    new Thread(new Runnable() {
      @Override
      public void run() {
        while (!stop) {
          o.dec();
        }
      }
    }).start();

    new Thread(new Runnable() {
      @Override
      public void run() {
        while (!stop) {
          o.print();
        }
      }
    }).start();

    Thread.currentThread().sleep(1000);
    stop = true;
  }
}