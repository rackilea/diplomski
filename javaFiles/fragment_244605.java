public abstract class Foo {

 protected String name;

 String getName() {
  return name;
 }
}

public class FooImpl1 extends Foo {

 public FooImpl1 () {
  name = "foo name1";
 }
}

public class FooImpl2 extends Foo {

 public FooImpl1 () {
  name = "foo name2";
 }
}