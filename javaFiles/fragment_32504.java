public class Aaa implements Runnable {
  public void run() {
    for (int i = 1; i < 5; i++) {
      try {
        Thread.sleep(500); // sleeps thread
      } catch (InterruptedException e) {
        System.out.println(e);
      }
      System.out.println(i);
    }
  }

  public static void main(String[] args) {
    Aaa m1 = new Aaa(); // creating one object
    Thread t1 = new Thread(m1); // Its thread
    Aaa m2 = new Aaa(); // creating second object of a class
    Thread t2 = new Thread(m2); // Its thread
    t1.start(); // calls m's run method in a new thread.
    t2.start();
  }

}