public class Visitor {

    private final String theName;
    private final String theGender;
    private final int theAge;
    private final String theCitizenship;

    public Visitor(final String theName, final String theGender, final int theAge, final String theCitizenship) {
        this.theName = theName;
        this.theGender = theGender;
        this.theAge = theAge;
        this.theCitizenship = theCitizenship;
    }

    public String getTheCitizenship() {
        return theCitizenship;
    }

    public int getTheAge() {
        return theAge;
    }

    public String getTheGender() {
        return theGender;
    }

    public String getTheName() {
        return theName;
    }
}