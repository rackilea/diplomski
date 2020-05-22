class InterfaceImpl implements Interface<AAndB<Integer>> {

    public AAndB<Integer> get() {
        final AAndB<Integer> aAndB = new AAndB<Integer>();
        return aAndB;
    }
}

interface Interface<T extends B<Integer> & A> {
     T get();
}