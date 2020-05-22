import java.util.ArrayList;
import java.util.List;

class Main {
  public static void main(String... args) {
    List<Thread> threads = new ArrayList<Thread>();

    System.out.println("----- First Test, static method -----");
    for (int i = 0; i < 4; ++i) {
      threads.add(new Thread(() -> {
        Main.m1();
      }));
    }
    for (Thread t : threads) {
      t.start();
    }
    for (Thread t : threads) {
      try {
        t.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    System.out.println("----- Second Test, non-static method -----");
    threads.clear();
    for (int i = 0; i < 4; ++i) {
      threads.add(new Thread(() -> {
        new Main().m2();
      }));
    }
    for (Thread t : threads) {
      t.start();
    }
    for (Thread t : threads) {
      try {
        t.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    System.out.println("----- Third Test, non-static method, same object -----");
    threads.clear();
    final Main m = new Main();
    for (int i = 0; i < 4; ++i) {
      threads.add(new Thread(() -> {
        m.m2();
      }));
    }
    for (Thread t : threads) {
      t.start();
    }
    for (Thread t : threads) {
      try {
        t.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public static synchronized void m1() {
    System.out.println(Thread.currentThread() + ": starting.");
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(Thread.currentThread() + ": stopping.");
  }

  public synchronized void m2() {
    System.out.println(Thread.currentThread() + ": starting.");
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(Thread.currentThread() + ": stopping.");
  }
}