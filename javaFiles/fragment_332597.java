public Student findStudentByName(String name) {
    for(Student studentObj : student) {
        if(studentObj.getName().equals(name)) {
            return studentObj;
        }
    }
    return null;
}