public void func1() {
    Foo o = new Foo();
    Foo exp = findVariable(o);
    Foo newFoo = new Foo(SomethingDifferent);
    exp = newFoo;
}