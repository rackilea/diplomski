class Bar {}

class Foo {
    Bar createBar() {
        return new Bar();
    }
}

public class Test {
    public static void main(String[] args) {
        Foo foo = new Foo();
        Bar bar = foo.createBar();
    }
}