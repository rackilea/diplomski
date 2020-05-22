public class Foo {
  int val;
  public Foo(int v) { val = v; }

  class Bar {
    public void printVal() {
      // this is the val belonging to our containing instance
      System.out.println(val);
    }
  }

  public Bar createBar() {
    return new Bar(); // equivalent of this.new Bar()
  }
}