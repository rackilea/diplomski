// Here myEntity is managed by entityManager1.
SomeEntity myEntity = entityManager1.find(SomeEntity.class, id);

// myEntity becomes detached.
entityManager1.close();

// I can still work with the java object.
myEntity.setSomeProperty("blah");

// Here myEntity becomes managed by entityManager2.
// It basically retrieves the current entity from the DB (based on its ID),
// then apply any change that was made to it while it was detached.
myEntity = entityManager2.merge(myEntity);

// If you commit at this point, the changes made to myEntity while
// it was detached will be persisted to the DB.