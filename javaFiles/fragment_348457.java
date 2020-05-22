public class Example {

    public static void main(String...args) {
        new C();
    }

    public static class A {
        public A() {
            System.out.println("A");
        }
    }
    public static class B extends A {
        public B() {
            System.out.println("B");
        }
    }
    public static class C extends B {
        public C() {
            System.out.println("C");
        }
    }
}