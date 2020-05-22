for (int i = 0; i < allStudentGrades.size(); i++) {
    StudentGrades sg = allStudentGrades.get(i);
    BigDecimal newScore = sg.getGradeSheetScoreTotalAchieved();
    if (lastScore.compareTo(newScore) != 0) {
        classRank = i + 1;
    }
    if (sg.equals(studentGrades)) {
        return classRank;
    }
    lastScore = newScore;
}