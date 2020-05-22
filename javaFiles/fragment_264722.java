List<Person> persons = createItSomehow();

Collections.sort(persons, Person.COMPARE_BY_NAME);
System.out.println(persons); // Ordered by name.

Collections.sort(persons, Person.COMPARE_BY_AGE);
System.out.println(persons); // Ordered by age.