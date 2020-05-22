//first, use your function to group students
Map<String, List<Student>> studlistGrouped = students.stream()
        .collect(Collectors.groupingBy(Student::getLocation, Collectors.toList()));

//then sort groups by minimum id in each of them
List<Student> sorted = studlistGrouped.entrySet().stream()
        .sorted(Comparator.comparing(e -> e.getValue().stream().map(Student::getId).min(Comparator.naturalOrder()).orElse(0)))
        //and also sort each group before collecting them in one list
        .flatMap(e -> e.getValue().stream().sorted(Comparator.comparing(Student::getId))).collect(Collectors.toList());