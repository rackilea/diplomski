final class PersonGrid extends Grid<Person> {

    public PersonGrid() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("foo"));
        persons.add(new Person("bar"));
        persons.add(new Person("foobar"));

        addColumn(Person::getName).setCaption("Name");

        setItems(persons);
    }

}