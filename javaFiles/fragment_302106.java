public findCollege(int collegeId) {
    College college = entityManager.find(College.class, collegeId);
    college.getStudents(); //will be populated
}

public findStudent(int studentId) {
    Student student = entityManager.find(Student.class, studentId);
    student.getCollege(); //will be populated
    student.getCollege().getStudents(); //will be populated
}