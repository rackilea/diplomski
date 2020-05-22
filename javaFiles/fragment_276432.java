EntityManagerFactory entityManagerFactory =
    Persistence.createEntityManagerFactory( unitName, config.getProperties() );
final Set<ManagedType<?>> managedTypes =
    entityManagerFactory.getMetamodel().getManagedTypes();
    for ( ManagedType<?> managedType : managedTypes ) {
    final Class<?> javaType = managedType.getJavaType();
    config.addAnnotatedClass( javaType );
}