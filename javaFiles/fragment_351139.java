public class Test {
    public static void main(String[] args) {
        new A().testPrintA();
    }
    public static class A {
        public void testPrintA() {
            System.out.println("Works from A.");
            new B().testPrintB();
        }
        public static class B {
            public void testPrintB() {System.out.println("Works from B.");}
        }
    }
}