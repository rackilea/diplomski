public interface PersonRepository extends CrudRepository<Person, Long> {
    <S extends T> Iterable<S> findAll(Example<S> example);
}

...

Person person = new Person();
person.setFirstname("Dave");
person.setCity("Seattle");
Iterable<Person> davesFromSeattle = personRepository.findAll(Example.of(person));