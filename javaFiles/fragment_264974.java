@Configuration
public class MockServletContextAwareProcessor {

public static void setServletContext(ServletContext sc) {
    servletContext = sc;
}    
private static ServletContext getServletContext() {
    return servletContext;
}
private static ServletContext servletContext;    

@Configuration
@Profile("server-test")
static class ServerTestContext {

    static public @Bean
    ServletContextAwareProcessor 
        scap() {
            ServletContext sc = getServletContext();
            return new ServletContextAwareProcessor(sc);
    }
}    
}