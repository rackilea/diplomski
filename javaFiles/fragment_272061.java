final List<List<Person>> groupedPersons = persons.stream()
        .collect(Collectors.groupingBy(o -> o.address.streetId))
        .entrySet().stream()
        .map(Map.Entry::getValue).collect(Collectors.toList());
// Code for printing out
groupedPersons.forEach(people -> {
    System.out.print("[");
    System.out.print(people.stream().map(person -> String.format("person%d", person.personId)).collect(Collectors.joining(",")));
    System.out.print("]");
});