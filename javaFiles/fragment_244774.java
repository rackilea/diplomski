public class MyImmutableBuilder {
  private int foo;
  private int bar;
  public MyImmutableBuilder foo(int val) { foo = val; return this; }
  public MyImmutableBuilder bar(int val) { bar = val; return this; }
  public MyImmutable build() { return new MyImmutable(foo, bar); }
}