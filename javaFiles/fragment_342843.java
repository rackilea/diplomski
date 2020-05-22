List<Student> studentList;
List<Student> algorithmsCourseStudentList = 
    studentList.stream()
               .filter(a -> a.getCourses()
                             .stream()
                             .anyMatch(c -> c.getCourseName().equals("Algorithms")))
               .collect(Collectors.toList());