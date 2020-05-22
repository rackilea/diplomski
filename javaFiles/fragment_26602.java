/**
 * Student class
 * Created by Michael
 * Creation date 4/5/2016.
 * @link https://stackoverflow.com/questions/36439416/how-to-read-objects-from-an-input-file-and-write-to-an-output-file
 */
public class Student {
    private String lastName;
    private String firstName;
    private String id;
    private double gpa;
    private int year;

    public Student(String lastName, String firstName, String id, double gpa, int year) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.id = id;
        this.gpa = gpa;
        this.year = year;
    }

    public boolean isHonors() {
        return this.gpa > 3.5;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Student{");
        sb.append("lastName='").append(lastName).append('\'');
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", id='").append(id).append('\'');
        sb.append(", gpa=").append(gpa);
        sb.append(", year=").append(year);
        sb.append('}');
        return sb.toString();
    }
}