class A {
    private int field;

    public void doSomething() {
        new Runnable() {
            @Override
            public void run() {
                field++; // Valid
            }
        }
    }
}