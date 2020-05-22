@Configuration
public class SpringConfig extends WebMvcConfigurerAdapter
{
   // ... init stuff if needed

@Override
public void configureContentNegotiation(ContentNegotiationConfigurer configurer)
{
    // setup content negotiation (automatic detection of content types)
    configurer
            // use format parameter and extension to detect mimetype
            .favorPathExtension(true).favorParameter(true)
            // set default mimetype
            .defaultContentType(MediaType.APPLICATION_XML)
            .mediaType(...)
            // and so on ....
 }

 /**
 * Configuration of the {@link DispatcherServlet} bean.
 *
 * <p>This is needed because Spring and Spring Boot auto-configuration override each other.</p>
 *
 * @see <a href="http://stackoverflow.com/questions/28902374/spring-boot-rest-service-exception-handling">
 *      Stackoverflow - Spring Boot REST service exception handling</a>
 *
 * @param dispatcher dispatcher servlet instance
 */
@Autowired
@SuppressWarnings ("SpringJavaAutowiringInspection")
public void setupDispatcherServlet(DispatcherServlet dispatcher)
{
    // FIX: for global REST error handling
    // enable exceptions if endpoint not found (instead of static error page)
    dispatcher.setThrowExceptionIfNoHandlerFound(true);
}

/**
 * Creates the error properties used to setup the global REST error controller.
 *
 * <p>Using {@link ErrorProperties} is compliant to base implementation if Spring Boot's
 * {@link org.springframework.boot.autoconfigure.web.BasicErrorController}.</p>
 *
 *
 * @return error properties
 */
@Bean
public ErrorProperties errorProperties()
{
    ErrorProperties properties = new ErrorProperties();

    properties.setIncludeStacktrace(ErrorProperties.IncludeStacktrace.NEVER);
    properties.setPath("/error");

    return properties;
}
// ...
}