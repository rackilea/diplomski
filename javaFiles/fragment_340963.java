public class C {
  private final int x;
  public C() {
    int x_val;
    try {
      x_val = Integer.parseInt("someinput");
    }
    catch(NumberFormatException e) {
      x_val = 42;
    }
    this.x = x_val;
  }
}