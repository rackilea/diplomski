private int deleteMyEntities(final List<Integer> ids) {
  final Session session = SomeHelper.getOpenSession();
  Transaction tx = session.beginTransaction();
  try {
    final int affectedCount = session.createQuery("delete MyEntity where id in (:ids)")
        .setParameterList("ids", ids)
        .executeUpdate();
    if (affectedCount == ids.size()) {
      tx.commit();
      return affectedCount;
    } else {
      throw new HibernateException("Delete count does not match target count.");
    }
  } catch (Exception e) {
     tx.rollback();
     throw e;
  } 
}