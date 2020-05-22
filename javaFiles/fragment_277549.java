public Single {
    private static Single s = new Single();
    public static Single getInstance() { return s; }
    private Single() { ... }

    public void foo() {
        Single ss = new Single();  // breaks the invariant!!
        ...
    }
}