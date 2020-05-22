class Foo
{
  private static final void foo()
  {
    System.out.println("hollywood!");
  }

  public Foo()
  {
    foo();      // both compile
    Foo.foo();  // but I prefer this one
  }
}