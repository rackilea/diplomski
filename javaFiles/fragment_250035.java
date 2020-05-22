return
this.students()
    .stream()
    .collect(Collectors.groupingBy(student -> student.getAssignedProjects().size(),
             TreeMap::new,
             Collectors.toSet()))
    .lastEntry()
    .getValue();