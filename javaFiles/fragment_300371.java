Map<String, List<StudentClass>> groupByTeachers = 
       studentClasses.stream()
                     .collect(groupingBy(
                          StudentClass::getTeacher,
                          limitingList(2)
                     ));