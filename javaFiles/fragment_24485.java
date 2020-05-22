public void deleteStudents(){
        List<Student> all = studentRepository.findAll();
       deleteStudent(all.get(2));
     }

     public void deleteStudent(Student student) {

        Set<Course> courses = student.getCourses();

         for (Course course: courses) {
             if (course.getStudents().size() == 1 ){
                 course.getGuide().getCourses().remove(course);

                 courseRepository.delete(course);
             } else {
                 course.getStudents().remove(student);
             }
         }
         studentRepository.delete(student);
    }