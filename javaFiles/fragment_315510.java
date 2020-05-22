public class Student implements Comparable<Student> {
    // we use encapsulation and set the fields' access to private
    private String name;
    private int age;
    private int marks;
    // we use encapsulation and have setters/getters/constructor access for the private fields
    public Student(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public int getMarks() {
        return marks;
    }
    public void setMarks(int marks) {
        this.marks = marks;
    }
    // TODO other setters/getters
    // here we implement the compareTo method and decide which int to return according to the "marks" field
    @Override
    public int compareTo(Student otherStudent) {
        if (marks < otherStudent.getMarks()) {
            return -1;
        }
        else if (marks > otherStudent.getMarks()) {
            return 1;
        }
        else {
            return 0;
        }
    }