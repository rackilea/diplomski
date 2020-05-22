List<Person> sortedListOfPeopleByPredicateMatchCOunt = 
  listPersArrays
    .asList(listPersons)
    .stream()
    .sorted(
      Comparator.comparingLong(p -> predicates.stream().filter(predicate -> predicate.test(p)).count()))
       // Reverse because we want higher numbers to come first.
       .reversed())
    .collect(Collectors.toList());