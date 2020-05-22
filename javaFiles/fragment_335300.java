public YourComponentImpl implements YourComponent {
  @Override public Foo createFoo() {
    Foo foo = new Foo();
    foo.repo = new Repository();
    return foo;
  }
}