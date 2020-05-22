public static Student getStudentByNumber(int number, Collection<Student> students) {
    for (Student student : students) {
        if (student.getStudentNumber() == number) {
            return student;
        }
    }
    return null;
}