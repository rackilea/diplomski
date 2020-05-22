List<Person> data = new ArrayList<>();
  data.add(new Person(1, Max, 4);
  data.add(new Person(2, Richard, 7); 
  data.add(new Person(3, Tom, 4); 

  Map<Integer, Person> map = new HashMap<>();
  data.forEach(person -> map.put(person.getId(), person));

  // new Data incoming
  // could be the same Person (all 3 variables same)
  // could be existing Person but with changed variables (id stays the same)
  // could be completely new Person (new id)
  Person newPerson = ...;
  map.put(newPerson.getId(), newPerson);