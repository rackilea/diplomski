interface Foo() {
     int calculate();
}

class Bar implements Foo {
     public int calculate() {
        return 1+1;
     }
}

class Baz implements Foo {
     public int calculate() {
        return 2+2;
     }
}

Foo foo = getFoo();
int result = foo.calculate();