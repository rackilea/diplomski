public static <T extends Object> void saveEntityDb(T... entityList) {
  //local variable!
  final Session session = Hibernate.getSessionFactory().openSession();
  Transaction tx = null;
  try {
    if (session.isConnected()) {
      tx = session.beginTransaction();
      for (T entity : entityList) {
        session.saveOrUpdate(entity);
      }
      session.flush();
      tx.commit();
    }
  } catch (HibernateException ex) {
    if (tx != null && tx.getStatus().canRollback()) {
      tx.rollback();
    }
  } finally {
    if (session != null) {
      session.close();
    }
  }
}