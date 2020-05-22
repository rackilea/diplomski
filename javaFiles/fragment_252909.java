class Proxy{
  private Foo customType;
  ..
}

interface Foo{
  public String foo();
  ..
}

class FooImpl implements Foo{
  public String foo();
  ...
}