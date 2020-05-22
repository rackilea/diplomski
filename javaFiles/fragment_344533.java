public <X> Root<X> from(Class<X> entityClass) {
    EntityType<X> entityType = criteriaBuilder.getEntityManagerFactory()
            .getMetamodel()
            .entity( entityClass );
    if ( entityType == null ) {
        throw new IllegalArgumentException( entityClass + " is not an entity" );
    }
    return from( entityType );
}

public <X> Root<X> from(EntityType<X> entityType) {
    RootImpl<X> root = new RootImpl<X>( criteriaBuilder, entityType );
    roots.add( root );
    return root;
}