PersistenceUtil persistenceUnitUtil = Persistence.getPersistenceUtil();

boolean personInitialized = persistenceUnitUtil.isLoaded(person);

boolean personBooksInitialized = persistenceUnitUtil.isLoaded(person.getBooks());

boolean personNameInitialized = persistenceUnitUtil.isLoaded(person, "name");