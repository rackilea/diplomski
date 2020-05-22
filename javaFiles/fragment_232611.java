if (type == StudentType.GRADUATE) {
    boolean thesis = getThesisStatus();
    String thesisString = Boolean.toString(thesis);
    ClassStanding studyType = null;//getStudy(); <-- change this line
    String profName = getProfName();
    studentList.add(new Student.Graduate( thesis, studyType, profName));
}