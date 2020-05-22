List<Person> persons = new ArrayList<>();
persons.add(new Person("abc", 23, 1234L));
persons.add(new Person("abc", 12, 2345L));
persons.add(new Person("def", 99, 9999L));

Collections.sort(persons, new Comparator<Person>() {
    public int compare(Person o1, Person o2) {
            return (int) (o2.creationDate - o1.creationDate);
    }
});

Set<Person> personsHashed = new TreeSet<>(new Comparator<Person>() {
    public int compare(Person o1, Person o2) {
        return o2.name.compareTo(o1.name);
    }
});
personsHashed.addAll(persons);