final class A {
  private final int x;
  A(int x) { this.x = x; }
  public getX() { return x; }
}

class Main {
  static volatile A a1 = null;
  static A a2 = null;
  public static void main(String[] args) {
    new Thread(new Runnable() { void run() { try {
      while (a1 == null) Thread.sleep(50);
      System.out.println(a1.getX()); } catch (Throwable t) {}
    }}).start()
    new Thread(new Runnable() { void run() { try {
      while (a2 == null) Thread.sleep(50);
      System.out.println(a2.getX()); } catch (Throwable t) {}
    }}).start()
    a1 = new A(1); a2 = new A(1);
  }
}