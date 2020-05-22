Map<Integer, List<String>> collect = 
    members.stream()
           .collect(Collectors.groupingBy(
               Person::getAge,
               Collectors.mapping(Person::getName, Collectors.toList()))
           );