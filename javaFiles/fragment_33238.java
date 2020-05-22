private BarFoo {
   public com.very.long.prefix.bar.Foo realFoo;
}

private BazFoo extends com.very.long.prefix.bar.Foo{
  public com.very.long.prefix.baz.Foo realFoo;
}

class X {
    BarFoo a;
    BazFoo b;

    //now if you need to pass them
    someMethodThatTakesBazFoo(b.realFoo);
}