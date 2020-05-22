import java.util.*;

public class ImmutabilityExample {
    public static void main(String[] args) {
        Student student = new Student("Joe", "Underwater Basketweaving 101");
        Tutor tutor = new Tutor("Bill", new Student[] {student});
        Set<Student> students = tutor.getTutees();
        System.out.println("before=" + students);
        students.iterator().next().setName("Mary");
        System.out.println("" + tutor.getTutees());
    }
}

class Student {
    private String name;
    private String course;

    public Student(String name, String course) {
        this.name = name;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }
    public String toString() {
        return "Student, name=" + name + ", course=" + course;
    }
}

final class Tutor {
    private String name;
    private final Set<Student> tutees;

    public Tutor(String name, Student[] students) {
        this.name = name;
        tutees = new HashSet<Student>();
        for (int i = 0; i < students.length; i++) {
            tutees.add(students[i]);
        }
    }

    public Set<Student> getTutees() {
        return Collections.unmodifiableSet(tutees);
    }

    public String getName() {
        return name;
    }
}