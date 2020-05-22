public class Bar {

  public static interface Func {
    boolean func(Foo current, Foo other);
  }

  public static Func test1 = new Func() {
    @Override
    public boolean func(Foo current, Foo other) {
      return current.test1(other);
    }
  };

  public Bar doSomething() {
    _foos = new Foo[4];
    _foos[0] = getTest(test1);
    //...
  }

  private Foo _getTest(Func func) {
    Foo current = _foos[ 0 ];

      for ( int i = 1; i != _foos.length; i++ ) {
        current = func(current, _foos[ i ] ) ? _foos[ i ] : current;
      }
    return current;
  }

}