public class Diploma {
    public Diploma(String name, double GPA, String degreeField, DiplomaType diplomaType) {
        this.name = name;
        this.GPA = GPA;
        this.degreeField = degreeField;
        this.diplomaType = diplomaType;
    }
}

public class DiplomaWithHonors extends Diploma {
    public DiplomaWithHonors(String name, double GPA, String degreeField, DiplomaType diplomaType) {
        super(name, GPA, degreeField, diplomaType);
        calculateHonors();
     }
}