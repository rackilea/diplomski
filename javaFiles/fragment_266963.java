class MyClass {
  private String foo;
  private OtherClass bar;
  private int x;
  MyClass(String f, OtherClass b, int x) {
    foo = f;
    bar = b;
    this.x = x;
  }

  MyClass(MyClass o) {
    //make sure to call the copy constructor of OtherClass
    this(new String(o.foo), new OtherClass(o.bar), o.x);
  }
  // getters and setters
}