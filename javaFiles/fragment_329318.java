entityManager.createQuery("UPDATE SimpleTable s " +
               "SET s.address.state = ?1 " +
               "WHERE s.address.country = ?2")
  .setParameter(1, "FL")
  .setParameter(2, "US")
  .executeUpdate();