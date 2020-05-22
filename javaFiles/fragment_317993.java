org.apache.log4j.LogManager.resetConfiguration( );
if ( System.getProperty( "log4j.config" ) != null ) {
    DOMConfigurator.configureAndWatch( System.getProperty( "log4j.config" ) );
}
else {
    DOMConfigurator.configure( Loader.getResource( "log4j.properties" ) );
}