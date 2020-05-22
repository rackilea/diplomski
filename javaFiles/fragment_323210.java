class A {
    static class B {
        void f() {
            System.out.println("f()");
        }
    }
}

public class Foo {    
    public static void main(String... args) {
        new A.B().f();
    }
}