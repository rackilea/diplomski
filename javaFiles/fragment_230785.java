public class Person {

    DOBGender dobGender;
    FamilyGivenName fgn;

    public Person() {
        dobGender = new DOBGender();
        fgn = new FamilyGivenName();
    }

    public DOBGender getDobGender() {
        return dobGender;
    }


    public FamilyGivenName getFgn() {
        return fgn;
    }

}