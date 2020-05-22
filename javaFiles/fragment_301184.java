final Set<Person> persons = ...
Set<Person> filteredPersons = names.stream()
    .flatMap(n -> 
        persons.stream().filter(p -> n.equals(p.getName()))
    )
    .collect(Collectors.toCollection(LinkedHashSet::new));