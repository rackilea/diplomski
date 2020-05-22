public class KeepRunning {
  public static void main(String[] args) {
    Superdaemon d = new Superdaemon();
    d.start();
    System.out.println(Thread.currentThread().getName() + ": leaving main()");
  }
}

class Superdaemon extends Thread {
  public void run() {
    System.out.println(Thread.currentThread().getName() + ": starting");
    try { Thread.sleep(2000); } catch(InterruptedException e) {}
    System.out.println(Thread.currentThread().getName() + ": completing");
  }
}