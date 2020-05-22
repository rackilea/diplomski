public class Student implements Comparable<Student> {
    String name;
    int id;
    double gpa;

    public Student(String name, int id, double gpa) {
        this.name = name;
        this.id = id;
        this.gpa = gpa;
    }

    @Override
    public int compareTo(Student o2) {
        int c;
        c = this.name.compareToIgnoreCase(o2.name);
        if (c == 0) {
            c = Double.compare(this.gpa, o2.gpa);
        }
        return c;
    }

}