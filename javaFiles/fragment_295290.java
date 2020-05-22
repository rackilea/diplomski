strArr.stream()
    .map(str -> "https://" + strArr)
    .map(url -> getPersons(url))
    .flatMap(persons -> persons.stream())
    .filter(Objects::nonNull)
    .map(Person::getName)
    .filter(Objects::nonNull)
    .collect(Collectors.toList());