public class Foo {
  int foo;
}

class Bar {
  int bar;

  public static Bar fromFoo(Foo foo) {
    return new Bar(foo.foo);
  }

  public Bar(int bar) {
    this.bar = bar;
  }

}