public class Student implements Comparable<Student> {
    @Override
    public int compareTo(Student o) {
        return this.getName().compareTo(o.getName());
    }
}