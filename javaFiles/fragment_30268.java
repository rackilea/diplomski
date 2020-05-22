class FooOnSteroids extends Foo implements Trait1, Trait2 {
  public final String Trait1$$super$bar() {
    // call superclass 'bar' method version
    return Foo.bar();
  }

  public final String Trait2$$super$bar() {
    return Trait1$class.bar(this);
  }

  public String bar() {
    return Trait2$class.bar(this);
  }      
}