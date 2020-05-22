public class Outer {
  public Runnable getRunnable() {
    return new Runnable() {
      public void run() {
        System.out.println("hello");
      }
    };
  }
}