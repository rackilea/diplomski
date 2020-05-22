public class Visitors {

    private int numberOfVisitors = 0;
    private final Visitor[] visitors;

    public Visitors() {
        this.visitors = new Visitor[250];
    }

    public void AdmitNewVisitor(final String theName, final String theGender, final int theAge, final String theCitizenship ) {
        final Visitor visitor = new Visitor(theName, theGender, theAge, theCitizenship);
        this.visitors[this.numberOfVisitors] = visitor;
        this.numberOfVisitors++;
    }

    public Integer getNumberOfVisitors() {
        return this.numberOfVisitors;
    }
}