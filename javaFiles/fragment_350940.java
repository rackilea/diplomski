public static WebArchive testWar() {
    File[] libs
            = Maven.resolver().loadPomFromFile( "pom.xml" )
            .resolve(
                    "com.fasterxml.jackson.datatype:jackson-datatype-jsr310"
            )
            .withTransitivity()
            .asFile();

    return ShrinkWrap.create( WebArchive.class )
            .setWebXML( new File( "src/main/webapp/WEB-INF/web.xml" ) )
            .addAsWebInfResource( new File( "src/main/webapp/WEB-INF/jboss-web.xml" ) )
            .addAsWebInfResource( new File( "src/main/resources/logback.xml" ) )
            .addAsWebInfResource( new File( "src/main/webapp/WEB-INF/jboss-deployment-structure.xml" ) )
            .addAsWebInfResource( EmptyAsset.INSTANCE, "beans.xml" )
            .addPackages( false, Filters.exclude( ".*Test.*" ), getCorePackages() )
            .addAsLibraries( libs );
}