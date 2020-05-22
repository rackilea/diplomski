class A {
    int i = 0;
    class B {
        final A outer = A.this;
        int j = 1;
    }
}

class Test {
    public static void main() {
        A a = new A();
        A.B b = a.new B();
        A c = b.outer // get "a" back
    }
}