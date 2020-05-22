Session session = sessionFactory.openSession();
try {
  session.getTransaction().begin();
  // do whatever work you want to do here
  session.getTransaction().commit();
}
catch ( Throwable t ) {
  if ( session.getTransaction().isActive() ) {
    session.getTransaction().rollback();
  }
  throw t;
}
finally {
  session.close();
}