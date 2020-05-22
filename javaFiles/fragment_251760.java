for (int gradeA : thisStudent.getGrades()) {
    for (int gradeB : otherStudent.getGrades()) {
        if (gradeA == gradeB) return false;
    }
}
return true;