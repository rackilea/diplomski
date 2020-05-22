X myX = new X(3) {
    // Field unique to this subclass of X:
    private int baz;
    {
        // code here runs as if it were at the start of every constructor
        baz = ...;
    }
    @Override
    public void foo() { ... }
};