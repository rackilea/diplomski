class A {
    private int field;

    private class B {
        public void doSomething() {
            field++; // Valid
        }
    }
}