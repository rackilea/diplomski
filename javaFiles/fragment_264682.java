public interface Foo {
  public String bar();
}

public class FooImpl implements Foo {
  @Override
  public String bar() {  ...
}

public class StaticFoo  {
  private final static Foo foo = new FooImpl();
  public static String bar() {  return foo.bar() };
}