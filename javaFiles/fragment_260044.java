public class Student {
    String firstName;
    String lastName;
    String gpa

    public Student(String firstName, String lastName, String gpa){
        this.firstName = firstName;
        this.lastName = lastName;
        this.gpa = gpa;
    }

    // Perhaps some methods here

    public String getIdentity(){
        return this.lastName + ", " + this.firstName;
    }
}