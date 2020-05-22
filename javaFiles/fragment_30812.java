public class Person<T extends Person<T>> {
    public T setName(String name) {
        // do anything
        return (T)this;
    }
}

public class Student extends Person<Student> {
    public Student setStudentId(String id) {
        // do anything
        return this;
    }
}

public class Teacher extends Person<Teacher> {
    public Teacher setParkingLotId(int id) {
        // do anything
        return this;
    }
}