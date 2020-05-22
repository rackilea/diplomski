class Foo {
}

class Bar {
    Bar() throws Exception {
    }
}

void demo() throws Exception {
    Foo foo = new Foo() {
        Bar bar = new Bar();  // might throw
    };
}