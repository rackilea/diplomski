List<StudentSubject> resultList = studentList.stream()
        .collect(Collectors.groupingBy(Student::getId)) // until this point group by Id
        .entrySet()                                     // for each entry
        .stream()                                        
        .map(s -> new StudentSubject(                   // create a new StudentSubject
                s.getValue().get(0).getName(),          // you can use just the name of first element
                s.getValue().stream()                   // with a list of Result
                        .map(r -> new Result(r.getSubject(), r.getScore()))
                        .collect(Collectors.toList()))
        ).collect(Collectors.toList());                 // then collect every thing as a List