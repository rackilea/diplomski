class Foo {
    public enum Option{First, Second}
    public void doSomething(String name, Option option) {
       ...
    }
}

void test() {
    Foo foo = new Foo();
    foo.dosomething("blah", Foo.Option.Second);
}