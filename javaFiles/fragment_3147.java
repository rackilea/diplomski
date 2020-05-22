public class MyClass {
  private BitSet mask;
  public MyClass() {
    this(new BitSet(4),(m)->m.set(0,3));
  }
  public MyClass(BitSet mask,Consumer<BitSet> initializer) {
    initializer.accept(mask);
    this.mask = mask;
  }
}