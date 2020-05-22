public int compareTo(ApplnDoc otherData) {
Student thisStudent = new ArrayList<>(this.admAppln.getStudents()).get(0);
Student otherStudent = new ArrayList<>(otherData.admAppln.getStudents()).get(0);
    if(thisStudent.getRegisterNo() != null && 
       !thisStudent.getRegisterNo().isEmpty() &&
       otherStudent.getRegisterNo() != null && 
       !otherStudent.getRegisterNo().isEmpty()) {
           return thisStudent.getRegisterNo().compareTo(otherStudent.getRegisterNo());
    } else {
           return thisStudent.getId() - otherStudent.getId();
    }
}