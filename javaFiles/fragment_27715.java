@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
private void setFailedCount(String user_id) throws Exception {

      Session session = sessionFactory.openSession();
      Transaction tx = session.beginTransaction();
      String hqlUpdate = "UPDATE User SET loginDate= CURRENT_TIMESTAMP, loginAttempts=(SELECT COUNT(*) FROM loginHistory WHERE user_id=:user_id AND response!=:response AND TIMESTAMPDIFF(MINUTE,valTime,CURRENT_TIMESTAMP) <= 30*24*60) WHERE user_id=:user_id";
      int updatedEntities = session.createQuery( hqlUpdate )
              .setParameter("user_id", user_id)
              .setParameter("response", "OK")
              .executeUpdate();
      tx.commit();
      session.close();

   }