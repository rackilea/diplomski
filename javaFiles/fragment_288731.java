private Foo(String name, MutableObject mo) {
    this.name = name;
    this.mo = mo;
  }
  public Foo bar(Foo that) {
    return new Foo(this.name, that.mo);
  }
  public static Foo create(String name, MutableObject mo) {
    mo = mo.clone();
    if(!Foo.testValidity(mo)) // this test is very expensive
      throw new IllegalArgumentException();
    return new Foo(name, mo);
  }