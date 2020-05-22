Map<Integer, List<Student>> citiesIdsToStudentsList =
    students.stream()
            .flatMap(student -> student.getStates().stream().map(state -> new AbstractMap.SimpleEntry<>(student, state)))
            .flatMap(entry -> entry.getValue().getCities().stream().map(city -> new AbstractMap.SimpleEntry<>(entry.getKey(), city)))
            .collect(Collectors.groupingBy(
                entry -> entry.getValue().getId(),
                Collectors.mapping(Map.Entry::getKey, Collectors.toList())
            ));