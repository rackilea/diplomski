public class Bar implements IFoo {
  public Bar(IFoo foo, ...) {
    _foo = foo;
  }
  private IFoo _foo;
  // implement IFoo delegating all calls to _foo...
}