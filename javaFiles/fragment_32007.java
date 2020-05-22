void finishProcessing() {
   Session session = sessionFactory.openSession();
   Transaction tx = session.beginTransaction();
   ThreadLocalSessionContext.bind(session);
   boolean committed = false;
   try {
       underlying.finishProcessing();
       tx.commit();
       committed = true;
   } finally {
       if (!committed) tx.rollback();
       session.close();
       ThreadLocalSessionContext.unbind(sessionFactory);
   }
}