private Student findStudentWithName(List<Student> students, String name) {
    for (Student s : students) {
        if (s.getName().equalsIgnoreCase(name)) {
            return s;
        }
    }
    // no student found.
    return null;
}