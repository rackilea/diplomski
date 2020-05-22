@Transactional(readOnly=true)
public <T,E> T get( ILazyGetter<T,E> p_getter ) throws Exception {
  // reattach the object to the session    
  E l_entity = getEntityManager().merge( p_getter.getEntity() );

  T l_lazyData = p_getter.get( l_entity );

  // Just getting the data doesn't necessarily initialize it - 
  // explicitly initialize it depending on the data type.
  intializeEntity( l_lazyData );

  // return the getter data
  return l_lazyData;
}

/**
 * Attempt to initialize the entity so it is fully lazy loaded while in the transaction
 * @param p_entity
 */
protected void intializeEntity( Object p_entity ) {
  if( p_entity != null && p_entity instanceof Collection ) {
    Collection<?> l_entity = (Collection<?>)p_entity;
    l_entity.size(); // force the collection to load
  }
}