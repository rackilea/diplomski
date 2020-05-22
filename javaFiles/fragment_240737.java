public static Student getStudentByNumber(Collection<Student> students, int number) {
    return students.stream()
        .filter(student -> student.getStudentNumber() == number)
        .findFirst()
        .orElse(null);
}