public class MyClass {
  private BitSet mask;
  public MyClass() {
    this(new BitSet(4) {{ set(0,3); }});
  }
  public MyClass(BitSet mask) {
    this.mask = mask;
  }
}