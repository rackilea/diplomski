class Foo {
  private Bar bar; // this guy is null

  public Foo() {
    Bar bar = new Bar(); // the class field is *still* null
                       // since this bar variable is local to the constructor only.
  }
}