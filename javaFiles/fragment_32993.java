public List<Dog> getDogsByDeletedFlag(boolean deletedFlag) {
  return hibernate.getCurrentSession()
        .createQuery( "SELECT d FROM Dog d WHERE d.deleted = :deletedFlag" )
        .setParameter( "deletedFlag", deletedFlag )
        .getResultList();
}