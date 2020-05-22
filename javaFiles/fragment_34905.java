// each row of our JTable holds a Course object's data
class Course {
    private String name;
    private double grade;

    public Course(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    // hashcode and equals based on name (or courseNumber)
}