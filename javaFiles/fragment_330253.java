records.stream()
    .collect(
         Collectors.groupingBy(
             Record::getStudentId, 
             Collectors.maxBy(Compartor.comparingInt(Record::getPoint))
         )
    );