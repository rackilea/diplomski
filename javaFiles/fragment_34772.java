QPerson person = QPerson.person;
List<Tuple> tuples = getQuerydsl()
        .createQuery()
        .from(person)
        .where(person.archived.eq(Boolean.FALSE))
        .select(person.initial, 
                person.firstName,
                person.lastName)
        .fetch();

List<String> names = tuples.stream()
        .map(t ->
                t.get(person.initial) +
                " " +
                t.get(person.firstName) +
                " " +
                t.get(person.lastName))
        .distinct()
        .collect(Collectors.toList());