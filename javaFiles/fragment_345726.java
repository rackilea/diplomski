public class Foo {

  public static final Foo Bar1 = new Foo(5, 7);

  public Foo(int someProperty, int anotherProperty) {
    this.someProperty = someProperty;
    this.anotherProperty = anotherProperty;
  }

  public int someProperty;

  public int anotherProperty;
}