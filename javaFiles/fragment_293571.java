class A {
    private int field;

    private static class B {
        public void doSomething(A a) {
            a.field++; // Valid
        }
    }
}