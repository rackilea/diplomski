public Dog getFirstDogByDeletedFlag(boolean deletedFlag) {
  return hibernate.getCurrentSession()
        .createQuery( "SELECT d FROM Dog d WHERE d.deleted = :deletedFlag" )
        .setParameter( "deletedFlag", deletedFlag )
        .setMaxResults( 1 ) // only gets the first hit
        .getSingleResult(); 
}