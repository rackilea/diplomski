List<List<Person>> families = people.stream()
            .collect(Collectors.groupingBy(p -> p.familyName))
            .entrySet()
            .stream()
            .map(e -> e.getValue())
            .collect(Collectors.toList());