Student student = filledForm.get();
List<Student> courses= new LinkedList<Course>();
for(Map.Entry<String, String> entry : filledForm.data().entrySet()){
    if(entry.getKey().contains("courses")){
        Course c = Course.find(Long.parseLong(entry.getValue()));
        courses.add(c);
    }
}
student.setCourses(courses);