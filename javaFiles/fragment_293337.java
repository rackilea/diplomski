@Configuration

@ImportResource({
    "classpath:/WEB-INF/mvc-dispatcher-servlet.xml",
    "classpath:/WEB-INF/spring-servlet.xml"})

@ComponentScan(basePackages = {"com.portal"})
public class IntegrationServerWebConfig {
}