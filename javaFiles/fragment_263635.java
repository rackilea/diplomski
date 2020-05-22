public class Student {

    private String firstname;
    private String lastname;
    private String major;
    private double gpa;

    public Student(
        String firstname,
        String lastname,
        String major,
        double gpa) {

        this.firstname = firstname;
        this.lastname = lastname;
        this.major = major;
        this.gpa = gpa;
    }

    @Override
    public String toString() {

        return "Student [firstname=" + firstname + ", lastname=" + lastname + ", major="
                + major + ", gpa=" + gpa + "]";
    }
}