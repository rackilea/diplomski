courseList.stream()
          .map(Course::getStudentList)
          .flatMap(Collection::stream)
          .filter(student -> student.getStudentName().equals(name))
          .findFirst()
          .map(Student::getSubjectList)
          .ifPresent(subjectList -> subjectList.add(
              Subject.newBuilder()
                     .subjectName(infoName)
                     .details("fofofofof")
                     .value(10.0)
                     .build())
          );