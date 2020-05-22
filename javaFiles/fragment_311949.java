public class Student {

    // non-static fields for each instance
    public double gpa;

    // static field for the class
    public static numStudents;

    public Student() {
        // create student by setting object (non-static) fields, for example...
        this.gpa = 3.2;

        // edit static variable
        numStudents++; // notice how there is no `this` keyword - this changes a static variable
    }

}