if ( barrier == 1 ) {} //read
PersistenceProviderResolver currentResolver = resolvers.get( cl );
if ( currentResolver == null ) {
    currentResolver = new CachingPersistenceProviderResolver( cl );
    resolvers.put( cl, currentResolver );
    barrier = 1; //write
}