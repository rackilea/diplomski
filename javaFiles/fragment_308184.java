import java.util.Comparator;

public class Student implements Comparable<Student> {

    private Double rank;
    private Double dist;

    public Student(double rank, double dist) {

        this.rank = rank;
        this.dist = dist;

    }

    public Double getRank() {
        return rank;
    }

    public Double getDist() {
        return dist;
    }

    public int compareTo(Student student) {

        return (int) (student.rank - this.rank);

    }

    public static Comparator<Student> StudentComparator = new Comparator<Student>() {

        public int compare(Student student1, Student student2) {

            Double first = student1.dist;
            Double second = student2.dist;

            return (int) (second - first);

        }

    };
}