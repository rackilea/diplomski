public class Student extends JButton {
    ...
    public Student(String firstName, String lastName, int age) {
        return super(firstName + lastName + Integer.toString(age));
    }
    ...
}