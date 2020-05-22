@WebListener
public class MyServletContextListener implements ServletContextListener {

    public void contextInitialized( ServletContextEvent sce ) {
        Instant instant = Instant.now() ;  // Capture current moment in UTC.
        // By default `toString` generates string in standard ISO 8601 format. 
        // Easy to parse: Instant.parse( "2017-01-23T01:23:45.123456789Z" );
        String instantIso8601 = instant.toString() ;  

        // Remember the launch time as an attribute on the context.
        sce.getServletContext().setAttribute( "launch_instant" , instantIso8601 ) ;
        // Or save your moment in some class variable mentioned in Question.
        someObjectOfSomeClass.setLaunchInstant( instant );
    }

    public void contextDestroyed( ServletContextEvent sce ) {
        …
    }

}