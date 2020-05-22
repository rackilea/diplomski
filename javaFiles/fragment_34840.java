@Configuration
@Profile("dev")
@PropertySource("file:///${user.home}/.devopsbuddy/application-dev.properties")
public class DevelopmentConfig {

@Bean
public EmailService emailService() {
    return new MockEmailService();
}

@Bean
public ServletRegistrationBean h2ConsoleServletRegistration() {
    ServletRegistrationBean bean = new ServletRegistrationBean(new WebServlet());
    bean.addUrlMappings("/console/*");
    return bean;
}
}