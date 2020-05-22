Map<Integer, List<String>> peoplesNamesByAge = personen
            .stream()
            .collect(
                    Collectors.groupingBy(Person::getAge,
                            Collectors.mapping(Person::getName,
                                    Collectors.toList())));
    peoplesNamesByAge.forEach((k, v) -> System.out.printf("%2d: %s\n", k, v));