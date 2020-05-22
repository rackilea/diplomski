public class Student implements Comparable<Student> {
    //... the rest of the class
    public int compareTo(Student s) {
        return Integer.compare(this.grade, s.grade);
    }
}