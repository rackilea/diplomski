public static List<Person> getDuplicates(final List<Person> personList) {
  return getDuplicatesMap(personList).values().stream()
      .filter(duplicates -> duplicates.size() > 1)
      .flatMap(Collection::stream)
      .collect(Collectors.toList());
}

private static Map<String, List<Person>> getDuplicatesMap(List<Person> personList) {
  return personList.stream().collect(groupingBy(Person::uniqueAttributes));
}