public <T> T getFirstAnimalByDeletedFlag(Class<T> clazz, boolean deletedFlag) {
  // NOTE: We assume that the class name is also the entity name.
  // Since you can explicitly name entities, e.g. @Entity(name = "MyName"), 
  // you'd need to pass this String value separately if you use this.

  StringBuilder sb = new StringBuilder();
  sb.append( "FROM " ).append( clazz.getName() ).append( " o " );
  sb.append(" WHERE o.deleted = :deletedFlag" );

  return hibernate.getCurrentSession()
         .createQuery( sb.toString(), clazz )
         .setParameter( "deletedFlag", deletedFlag )
         .setMaxResults( 1 )
         .getSingleResult();
}