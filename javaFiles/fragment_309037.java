Student student = studentList.get(indexPosition); 
//ArrayList gives this flexibility and that's the advantage of ArrayList over other Lists

if(student.getCoursesList()!=null && !student.getCoursesList().isEmpty()){
    for(Course course: student.getCoursesList()){
        System.out.println(course);
    }
}