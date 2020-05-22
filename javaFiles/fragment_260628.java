class Person{}
class Student extends Person{}

public class Test {
    public static void main(String[] args) {
        Person person = getPerson();
        Student student = (Student) person;
    }

    private Person getPerson() {
        return new Student();
    }
}