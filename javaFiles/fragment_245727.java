// Common code
Person person1 = new Person("A", "A");
Person person2 = new Person("B", "B");
Person person3 = new Person("C", "A");
Person person4 = new Person("A", "D");
Person person5 = new Person("E", "E");

MutableSet<Person> personSet1 = Sets.mutable.with(person1, person2, person3);
MutableSet<Person> personSet2 = Sets.mutable.with(person2, person4, person5);

HashingStrategy<Person> hashingStrategy =
    HashingStrategies.fromFunction(Person::getLastName);