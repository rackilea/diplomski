class Foo {
    final int x;
    Foo(int x) {
        this.x = x;
    }
    Foo() {
        this.x = 1;
    }
}

class Bar extends Foo {
    Bar(int x) {
    }
}