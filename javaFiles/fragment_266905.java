abstract class ConverterVisitor<T> implements Visitor<T> {

    public T visit(Visitable visitable) {
        throw new IllegalArgumentException("Type: " + visitable.getClass().getName() + " not supported");
    }


    public T visit(A visitable) {
        return visit((Visitable) visitable);
    }


    public T visit(B visitable) {
        return visit((Visitable) visitable);
    }

}

class AConverterVisitor extends ConverterVisitor<AOther> {

    @Override
    public AOther visit(A a) {
        return new AOther();
    }

}