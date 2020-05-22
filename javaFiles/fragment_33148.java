@Autowired
private PersonRepository personRepository;

Person findById(String name) {
    return this.personRepository.findById(name).orElse(null);
}

Integer getAge(String name) {
    // Either use the approach in #1, or do https://github.com/jxblum/contacts-application/blob/master/tests-example/src/test/java/example/tests/spring/data/gemfire/NullValueReturningRepositoryQueryMethodIntegrationTests.java#L143-L151.
}

...