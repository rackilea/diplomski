public void removePerson(int personId) {
  SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
  Session sess = sessionFactory.getCurrentSession();
  Transaction tx = sess.beginTransaction();

  try {
    Person person = (Person)sess.createQuery("from Person where id = "+personId).list().get(0);
    Set<Project> projects = person.getProjects();
    for (Project project : projects) {
      if (project.getPersons().contains(person)) {
        project.getPersons().remove(person);
        sess.saveOrUpdate(project);
      }
    }

    sess.delete(person);
    tx.commit();
  }  catch (Exception e) {
     System.err.println("Failed deleting Person: "+e.getMessage());
  }
}