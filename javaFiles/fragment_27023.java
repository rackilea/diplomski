personsList.stream()      
       .collect(Collectors.groupingBy(Person::getName))
       .values()
       .stream()
       .filter(list -> list.size() > 1)
       .flatMap(List::stream)
       .forEach(System.out::println);