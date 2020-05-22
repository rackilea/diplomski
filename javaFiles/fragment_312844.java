public Foo(String s, int i, boolean b) {
    this(new MyClass(s, i, b, OtherClassFactory.getInstance());
}

Foo(MyClass obj) {
   this.obj = obj;
}