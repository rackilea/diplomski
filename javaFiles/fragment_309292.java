abstract class A {
     String a = "superclass";

    abstract void test();
}

class B extends A {
    void test() {
        System.out.println(a); // Output superclass
    }
}