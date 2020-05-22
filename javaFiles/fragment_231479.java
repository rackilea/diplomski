Session session = getSession(dataSource, sessionFactory, Connection.TRANSACTION_SERIALIZABLE);

public Session getSession(DataSource dataSource, SessionFactory sessionFactory, int isolationLevel){

  // Get connection from current dataSource and set new isolation
  Connection connectionWithNewIsolation = dataSource.getConnection();
  connectionWithNewIsolation.setTransactionIsolation(isolationLevel);

  // Get session from current sessionFactory with the new isolation
  Session session = sessionFactory.openSession(connectionWithNewIsolation);

  // Hibernate 4.3
  //SessionFactory.openStatelessSession(Connection connection)
  // Hibernate 3.6
  //SessionFactory.openSession(Connection connection)
  //SessionFactory.openStatelessSession(Connection connection)

  return session;
}