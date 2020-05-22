class X {
    public X(int value) { ... } // no default constructor!
    public void foo() { ... }
}

X myX = new X(3) {
    @Override
    public void foo() { ... }
};