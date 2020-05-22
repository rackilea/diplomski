interface Visitor<T> {
    T visit(A a);
    T visit(B b);
    T visit(Visitable visitable);
}

interface Visitable {
    <T> T accept(Visitor<T> v);
}