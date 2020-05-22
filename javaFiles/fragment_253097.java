public interface IVisitor<T extends Object> {
    public T visit(ClassA element) throws VisitorException;
    public T visit(ClassB element) throws VisitorException;
}

public interface IVisitable {
    public <T extends Object> T accept(final IVisitor<T> visitor) throws VisitorException;
}

public class MyVisitor implements IVisitor<String> {
    private String concat;

    public MyVisitor(String concat) {
        this.concat = concat;
    }

    public String visit(ClassA classA) throws VisitorException {
        return this.concat + "A";
    }

    public String visit(ClassB classB) throws VisitorException {
        return this.concat + "B";
    }
}

public class ClassA implements IVisitable {
    public <T> T accept(final IVisitor<T> visitor) throws VisitorException {
        return visitor.visit(this);
    }
}

public class ClassB implements IVisitable {
    public <T> T accept(final IVisitor<T> visitor) throws VisitorException {
        return visitor.visit(this);
    }
}

// no return value needed?
public class MyOtherVisitor implements IVisitor<Void> {
    public Void visit(ClassA classA) throws VisitorException {
        return null;
    }

    public Void visit(ClassB classB) throws VisitorException {
        return null;
    }
}