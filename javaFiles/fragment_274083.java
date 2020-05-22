public void edit(Person person) {
  logger.debug("Editing existing person, which is a detached object");

  // Retrieve session from Hibernate
  Session session = sessionFactory.getCurrentSession();

  // Retrieve existing person via id, then copy everything from detached person 
  // to attached one, and return attached one
  Person existingPerson = (Person) session.merge(person);
}