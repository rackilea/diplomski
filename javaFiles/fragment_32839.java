import java.util.ArrayList;
import java.util.List;

public class Visitors {

    private final List<Visitor> visitors;

    public Visitors() {
        this.visitors = new ArrayList<Visitor>(); //Initialise the list within the constructor here.
    }

    public void AdmitNewVisitor(final String theName, final String theGender, final int theAge, final String theCitizenship ) {
        //create your new visitor with the new keyword. Then add it to the list of visitors.
        final Visitor visitor = new Visitor(theName, theGender, theAge, theCitizenship);
        this.visitors.add( visitor );
    }

    public Integer getNumberOfVisitors() {
        //There's no need to maintain the number of visitors yourself, you can let the List do it.
        return this.visitors.size();
    }
}