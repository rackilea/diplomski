Session session = sessionFactory.openSession();
try {
  session.getTransaction().begin();
  for ( int i = 0; i < 10000; ++i ) {
    Student student = new Student();
    ...        
    session.save( student );
  }
  session.getTransaction().commit();
}
catch( Throwable t ) {
  if ( session.getTransaction().getStatus() == TransactionStatus.ACTIVE ) {
    session.getTransaction().rollback();
  }
  throw t;
}
finally {
  session.close();
}