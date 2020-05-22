public class MyClass {
  private BitSet mask;
  public MyClass() {
    this(initialize(new BitSet(4),(m)->m.set(0,3)));
  }
  public MyClass(BitSet mask) {
    this.mask = mask;
  }
}