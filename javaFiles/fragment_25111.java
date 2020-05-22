Optional<Person> person = persons.stream()
        .filter(p -> personToUpdate.getName().equalsIgnoreCase(p.getName()))
        .findFirst();

if (person.isPresent()) {
    person.get().setAddress(personToUpdate.getAddress());
} else {
    persons.add(personToUpdate);
}