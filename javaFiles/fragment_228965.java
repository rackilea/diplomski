public static interface Copyable<T> {
    public T copy();
}

public static class Student implements Copyable<Student> {
    @Override
    public Student copy() {
        return new Student();
    }
}

public static class StudentPool<T extends Student> {
    public T copyStudent(Copyable<T> t) {
        return t.copy();
    }
}