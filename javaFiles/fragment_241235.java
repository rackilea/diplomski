ArrayList<Person> list = ...;
Vector<PersonName> vect = list.stream().map(t -> {
    PersonName name = new PersonName();
    name.lastName = t.lastName;
    name.name = t.name;
    return name;
}).collect(Collectors.toCollection(Vector::new));