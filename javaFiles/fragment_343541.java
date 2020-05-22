class Foo {
    Foo() throws Exception {
    }
}

void demo() throws Exception {
    Foo foo = new Foo() {  // might throw
    };
}