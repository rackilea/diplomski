Class aClass = ... // get the class from your scanning
EntityManagerFactory entityManagerFactory =
    Persistence.createEntityManagerFactory( unitName, config.getProperties() );
ManagedType<?> managedType = null;
try {
    managedType = entityManagerFactory.getMetamodel().managedType( aClass );
} catch ( IllegalArgumentException e ) {
    // happens when aClass isn't a type managed by the persistence unit
}
if ( managedType != null ) {
    config.addAnnotatedClass( aClass );
}