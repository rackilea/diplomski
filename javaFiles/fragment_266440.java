static class Person {
    private final Integer age;
    private final String name;

    public Person(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}

private enum GetAgeFunction implements Function<Person, Integer> {
    INSTANCE;

    @Override
    public Integer apply(Person person) {
        return person.getAge();
    }
}

private enum GetNameFunction implements Function<Person, String> {
    INSTANCE;

    @Override
    public String apply(Person person) {
        return person.getName();
    }
}

public void example() {
    List<Person> persons = ImmutableList.of(
            new Person(100, "Alice"),
            new Person(200, "Bob"),
            new Person(100, "Charles"),
            new Person(300, "Dave")
    );

    ListMultimap<Integer, String> ageToNames = getAgeToNamesMultimap(persons);

    System.out.println(ageToNames);

    // prints {100=[Alice, Charles], 200=[Bob], 300=[Dave]}
}

private ListMultimap<Integer, String> getAgeToNamesMultimap(List<Person> persons) {
    ImmutableListMultimap<Integer, Person> ageToPersons = Multimaps.index(persons, GetAgeFunction.INSTANCE);
    ListMultimap<Integer, String> ageToNames = Multimaps.transformValues(ageToPersons, GetNameFunction.INSTANCE);

    // Multimaps.transformValues() returns a *lazily* transformed view of "ageToPersons"
    // If we want to iterate multiple times over it, it's better to create a copy
    return ImmutableListMultimap.copyOf(ageToNames);
}