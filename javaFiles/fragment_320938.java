class D<T extends Element> implements B<T> {
    @Override
    public T doSomething(T foo) { return null;}
}

class E extends D<ChildElement> implements C<ChildElement> {
    @Override
    public ChildElement doSomething(ChildElement foo) { return null;}
}