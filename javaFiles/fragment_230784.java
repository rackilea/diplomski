//Component Classes

public class DOBGender {//Has the specific methods you want

}



public class FamilyGivenName {//Has the specific methods you want

}

//Then just plug them in to this class

public class Person {

    DOBGender dobGender;
    FamilyGivenName fgn;

    public Person(DOBGender dobGender, FamilyGivenName fgn) {//Plug them in
        this.dobGender = dobGender;
        this.fgn = fgn;
    }

    public DOBGender getDobGender() {
        return dobGender;
    }

    public void setDobGender(DOBGender dobGender) {
        this.dobGender = dobGender;
    }

    public FamilyGivenName getFgn() {
        return fgn;
    }

    public void setFgn(FamilyGivenName fgn) {
        this.fgn = fgn;
    }
}