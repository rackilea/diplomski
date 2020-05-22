package sample1;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class UseLock {

  public static void main(String[] args) {
    UseLock o = new UseLock();
    o.go();
  }

  private void go() {
    TotalPermits tp = new TotalPermits();

    tp.lock.writeLock().lock();

    Contender a = new Contender(tp, "thread-A");
    Contender b = new Contender(tp, "thread-B");
    Contender c = new Contender(tp, "thread-C");
    Contender d = new Contender(tp, "thread-D");

    a.start();
    b.start();
    c.start();
    d.start();

    tp.lock.writeLock().unlock();
  }
}

class TotalPermits {
  private static final boolean USE_FAIR = true;

  private int count = 1_000;
  ReentrantReadWriteLock lock = new ReentrantReadWriteLock(USE_FAIR);

  public boolean get() {
    try {
      lock.writeLock().lock();
      try {
        Thread.sleep(1);
      } catch (InterruptedException e) { }
      return --count>0;
    } finally {
      lock.writeLock().unlock();
    }
  }
}

class Contender extends Thread {
  private int count = 0;
  final String name;
  final TotalPermits tp;

  Contender(TotalPermits tp, String name) {
    this.tp = tp;
    this.name = name;
  }

  @Override
  public void run() {
    while ( tp.get() ) {
      count++;
    }
    System.out.printf("Thread %s finished, count=%d%n", name, count);
  }
}