public class Foo {
  private final Bar bar;

  public Foo(Bar bar) {
    Objects.requireNonNull(bar, "bar must not be null");
    this.bar = bar;
  }