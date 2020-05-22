public static Student getStudentByNumber(Collection<Student> students, int number) {
    for (Student student : students) {
        if (student.getStudentNumber() == number) {
            return student;
        }
    }
    return null;
}