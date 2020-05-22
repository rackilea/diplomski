import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Driver {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<Student>();

        students.add(new Student(1, "Dennis", "", Gender.MALE, ""));
        students.add(new Student(2, "Nico",   "", Gender.MALE, ""));
        students.add(new Student(3, "Dan",    "", Gender.MALE, ""));
        students.add(new Student(4, "Dan",    "", Gender.MALE, ""));
        students.add(new Student(5, "Dennis", "", Gender.MALE, ""));
        students.add(new Student(6, "Dan",    "", Gender.MALE, ""));

        // This works, if you add the Comparable interface the class.
        // SortingUtils.quickSort(students); 

        // Most of the time, you will have a custom Comparator
        SortingUtils.quickSort(students, new Comparator<Student>() {
            @Override
            public int compare(Student student1, Student student2) {
                int diff = student1.getGivenName().compareTo(student2.getGivenName());
                if (diff != 0) return diff;
                return Long.compare(student1.getId(), student2.getId());
            }
        });

        for (Student student : students) {
            System.out.println(student);
        }
    }
}