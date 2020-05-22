class Foo {
  private Bar bar; // class field is null here

  public Foo() {
    bar = new Bar();  // now no longer null. *** note the difference
  }
}