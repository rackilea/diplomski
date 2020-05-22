Function<Stream<Person>, IntStream> agesForSex(Person.Sex sex) {
    return stream -> stream
        .filter(p -> p.getGender() == sex)
        .mapToInt(Person::getAge);
}

double averageBob = StreamEx.of(roster)
        .filter(p -> "Bob".equals(p.getName()))
        .chain(agesForSex(Person.Sex.MALE)) // Compiles!
        .average()
        .getAsDouble();