private void readButtonClicked() {
    String id = idTextField.getText();
    Student student = findStudentWithId(id);
    showStudentInGUI(student);
}

private Student findStudentWithId(String id) {
    List<String> lines = readLinesInFile();
    List<Student> students = transformLinesIntoStudents(lines);
    Student studentWithId = findStudentWithId(students, id);
}

private Student findStudentWithId(List<Student> students, String id) {
    for (Student student : students) {
        if (student.getId().equals(id)) {
            return student;
        }
    }
    return null;
}

private List<Student> transformLinesIntoStudents(List<String> lines) {
    List<Student> students = new ArrayList<Student>(lines.size());
    for (String line : lines) {
        students.add(parseStudentLine(line);
    }
    return students;
}

...