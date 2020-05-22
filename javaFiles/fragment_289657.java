public class Foo {
  private BarFactory barFactory;

  public Foo(BarFactory factory) {
    this.barFactory = factory;
  }

  public void foo() {
    Bar bar = this.barFactory.createBar();
    bar.someMethod();
  }
}