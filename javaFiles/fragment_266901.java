class ConverterVisitor implements Visitor {


    // Added field and getter to store the other object in...
    private AbsOther other;

    public AbsOther getOther {
        return other;
    }

    public void visit(B b) {
        System.out.println("Convert a to BOther");
        other = new BOther();
    }

    public void visit(A a) {
        System.out.println("Convert a to AOther");
        other = new AOther();
    }

    @Override
    public void visit(Visitable visitable) {
        throw new IllegalArgumentException("Type: " + 
            visitable.getClass().getName() + " not supported");
    }

}