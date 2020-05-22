public class Person {
    int age = 18;
}

class Student extends Person {

    int age; // Hides the super variable

    public Student() {
        this.age = 22;
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.doSomthing();
    }

    void doSomthing() {
        System.out.println(this.age);
        System.out.println(super.age);
    }
}