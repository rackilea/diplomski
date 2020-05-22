class A {
    public void print(A a) {
        System.out.println("A.print(A)");
    }
}

class B extends A {
    public void print(A a) {
        System.out.println("B.print(A)");
    }
    public void print(B b) {
        System.out.println("B.print(B)");
    }
}

class C extends B {
    public void print(A a) {
        System.out.println("C.print(A)");
    }
    public void print(B b) {
        System.out.println("C.print(B)");
    }
    public void print(C c) {
        System.out.println("C.print(C)");
    }
}

class OverloadingDemo {
    public static void main (String [] args) {
        A ab = new B();
        A ac = new C();
        B bb = new B();
        B bc = new C();

        bc.print(new A());
        bc.print(new C());
        bc.print(new B());
        ab.print(new C());
        ac.print(new C());
        ac.print(new B());
        bb.print(new C());
    }
}