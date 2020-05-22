public class A {
  private B b = new B();

  public void callB() {
    b.process(17);
    b.process(22);
  }
}

public class B {
  public void process(int n) {
    // do stuff with n
  }
}