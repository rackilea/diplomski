public class Foo {
  private Object baz = "Hello";
  private class Bar {
    private Bar() {
      System.out.println(baz);
    }
  }
}