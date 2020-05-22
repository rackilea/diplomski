public class A {

  private final String g;
  private int x;

  public A(String g) {
    this.g = g;
    x_$eq(x() + g.length());
    x = 0;
  }

  public void x_$eq(int arg0) {
    x = arg0;
  }

  public int x() {
    return x;
  }

  public String g() {
    return g;
  }
}