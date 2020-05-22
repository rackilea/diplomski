class FooWrapper {
    private final BasicFoo obj;
    public FooWrapper(BasicFoo obj) {
        this.obj = obj;
    }
    public BasicFoo getWrapped() {
        return obj;
    }
    public int hashCode() {
        // Compute the hash code the way the BasicFoo computes it
    }
    public boolean equals(Object other) {
        // Compare the objects the way the BasicFoo does
    }
}