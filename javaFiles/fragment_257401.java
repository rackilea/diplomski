public class A {
  private class B {
      public int x;
  }
  public Vector<B> vector = new Vector<B>();

  public A() {
    vector.add(new B());
    vector.get(0).x = 10;
  }
}