interface Visitor {
    void visit(A a);
    void visit(B b);
    void visit(Visitable visitable);
}

interface Visitable {
    void accept(Visitor v);
}