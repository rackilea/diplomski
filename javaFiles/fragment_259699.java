public Person loadProject() {
  // First we load person from database
  Person person = personRepository.getOne(personId);
  // Then we clear the persistence context to evict detached exceptions
  entityManager.clear();
  person = (Person) Hibernate.unproxy(person); // Remove proxies from the object
  // Now we call Step 2 (clone shared references)
  person = entityReferencesService.cloneAddressReferences(person);
  return person;
}