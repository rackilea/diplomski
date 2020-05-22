class B {
  B() {
    m();
  }
  void m() {
    System.out.println("B.m()");
  }
}
class X extends B {
  int x = 8;
  void m() {
    System.out.println("X.m() x="+x);
  }
}

public class A {
    public static void main(String[] p) {
        X x = new X();
        x.m();
    }
}