public void addStudent(String names, int age) {
    STUDENT student = new STUDENT();        
    student.setNames(names);
    student.setAge(age);
    students.add(student);
}