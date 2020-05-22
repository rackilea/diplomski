public static StudentGrade findMinGrade(StudentGrade[] studentGrades) {
    StudentGrade studentGradeMin = studentGrades[0];
    for(int i=1; i < studentGrades.length; i++) {
        if(studentGrades[i].getGrade()[0] < studentGradeMin.getGrade()[0]) {
            studentGradeMin = studentGrades[i];
        }
    }
    return studentGradeMin;
}