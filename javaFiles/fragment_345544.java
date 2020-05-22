class ImmutableFooWrapper implements IFoo {
    private final IFoo delegate; // final provides safe publication automatically

    public ImmutableFooWrapper(IFoo delegate) {
        this.delegate = delegate;
    }
    ...
}

public IFoo immutableFoo(IFoo foo) {
    return new ImmutableFooWrapper(foo);
}