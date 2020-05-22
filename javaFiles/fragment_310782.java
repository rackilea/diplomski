public class A {
  public A() {
    Runnable r1 = new Runnable() {
      public void run() { ... }
    };
  }

  private static class Inner {
    ...
  }
}