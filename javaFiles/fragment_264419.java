List<Course> cse = new ArrayList<>();
cse.add(Course.getCourseByName("Discrete Mathematics"));
cse.add(Course.getCourseByName("Advanced Programming"));
temp.setRegisteredCourse(cse);

for(Course course: cse){
    cse.getRegisteredStudents().add(temp);
}