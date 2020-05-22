package qux;
public class Foo {
  void baz() { System.out.println("Foo"); }
}

package qux;
public class Bar extends Foo {
  @Override
  void baz() { System.out.println("Bar"); }
}