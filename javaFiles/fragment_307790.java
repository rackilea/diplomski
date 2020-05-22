public abstract class Person {
    // hi i am an abstract person
    // put your abstract methods here
}

public class Student extends Person {
    // This class provides the implementation of the abstract methods in the Person abstract class
    // implement the abstract methods of Person
}

public class Driver {
    public static void main(String[] args) {
        // Person p = new Person(); // wrong

        Student s = new Student();
    }
}