Map<String,List<Person>> groups =
    family.stream()
          .flatMap(p -> p.getGroups()
                         .stream()
                         .map(g -> new SimpleEntry<>(g,p)))
          .collect(Collectors.groupingBy(Map.Entry::getKey,
                                         Collectors.mapping(Map.Entry::getValue,
                                                            Collectors.toList())));