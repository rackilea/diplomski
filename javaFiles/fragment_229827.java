class A {
    private List<C> cs = new ArrayList<>();

    public Stream<C> getCs() {
        return cs.stream();
    }
}

class B {
    public void processCs(A a) {
        a.getCs().filter(C::hasFooness).forEach(...);
    }
}