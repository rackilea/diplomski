class A {
    public A() {
        System.out.println("A");
    }
}

class B extends A {
    public B() {
        super();
        System.out.println("B");
    }
}

class C extends B {
    public C() {
        super();
        System.out.println("C");
    }
}

public class Inheritance {
    public static void main(String[] args) {
        C c = new C();
    }
}