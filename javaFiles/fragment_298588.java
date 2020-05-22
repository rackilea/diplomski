public class Sample {

    public static void main(String[] args) {
        final MyGenericType<Student> action = new MyGenericType<>(Student.class);
        System.out.println(action); // Student
    }
}