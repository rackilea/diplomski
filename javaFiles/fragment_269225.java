List<Person> foundPersons = new ArrayList<>();
for (Person person : phoneBook) {
    if (person.firstName.contains("Jon")) {
        foundPersons.add(person);
    }
}