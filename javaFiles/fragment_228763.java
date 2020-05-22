public void displayStudentBasedOnSchool(String school){
    for(int i = 0; i < studentList.size(); ++i) {
        if(studentList.get(i).getSchool().equals(school)) {
            System.out.println(studentList.get(i).toString()); // here studentList.get(i) returns Student Object.
        }
    }
}