public abstract class AbstractA {

    public void foo() {
        AbstractB aB = createB();
        aB.setA(this);
    }

    /** factory method */
    abstract public AbstractB createB();

}

public abstract class AbstractB {

    private AbstractA theA;

    public void setA(AbstractA theA) {
        this.theA = theA;
    }

    // methods that use theA

}