// add your configuration here
getResourceSettings().setResourcePollFrequency( Duration.ONE_SECOND);
getResourceSettings().setDefaultCacheDuration(Duration.ONE_SECOND);

List list = new ArrayList();
list.add( new IResourceFinder() {
    @Override
    public IResourceStream find( Class<?> clazz, String pathname ) {
        File f = new File( "C:/MyProject/src/main/java/" + pathname );
        if ( f.exists() ) {
            return new FileResourceStream( f );
        }
        return null;
    }
} );

getResourceSettings().setResourceFinders( list );

getResourceSettings().setUseDefaultOnMissingResource(true);