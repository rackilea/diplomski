public class Foo {

  private Bar bar = new Bar();  // this field is visible throughout the object

  public Foo() {
    Baz baz = new Baz(); // this is only visible within this constructor
  }