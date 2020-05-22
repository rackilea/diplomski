@Test
public void testDoFoo() {
  Bar bar = mock(Bar.class);
  BarFactory myFactory = new BarFactory() {
    public Bar createBar() { return bar;}
  };

  Foo foo = new Foo(myFactory);
  foo.foo();

  verify(bar, times(1)).someMethod();
}