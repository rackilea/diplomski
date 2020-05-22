Map<String, Person> index = persons.stream()
    .collect(Collectors.toMap(Person::getName, Function.identity()));
Set<Person> filteredPersons = names.stream()
    .map(index::get)
    .filter(Objects::nonNull)
    .collect(Collectors.toCollection(LinkedHashSet::new));