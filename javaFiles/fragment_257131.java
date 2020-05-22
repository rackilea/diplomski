List<Map.Entry<String, List<Person>>> families = people.stream()
            .collect(Collectors.groupingBy(p -> p.familyName))
            .entrySet()
            .stream()
            .collect(Collectors.toList());
    System.out.println(families);