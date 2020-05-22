public StudentEnrollee locatePerson(String getStudentID) {
    for (StudentEnrollee personObject: studentList) {
        if (personObject.getStudentID().equals(getStudentID)) {
            return personObject;
        }
    }
    return null;
}