public class SomeClass {
    public static void main(String[] args) {
        Student student = new Student("Student", new Library());
        System.out.println(student); //Because you override #toString() you can just println the Student object.
    }
}