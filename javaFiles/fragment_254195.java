public Student retrieveStuId() {
    int searchId = askForStudentId();
    for (Student student: students) {
        if (student.getId == searchId) {
          return student;
        }
    }
    // No student found
    return null;
}