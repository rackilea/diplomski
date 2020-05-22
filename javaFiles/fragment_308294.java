@SpringBootApplication
public class JerseyApplication {

    public static void main(String[] args) {
        SpringApplication.run(JerseyApplication.class, args);
    }

    @Bean
    public ResourceConfig getResourceConfig(JerseyProperties jerseyProperties) {
        return new JerseyConfig(jerseyProperties);
    }

    @Bean
    public ServletRegistrationBean jerseyServletRegistration(
        JerseyProperties jerseyProperties, ResourceConfig config) {
        ServletRegistrationBean registration = new ServletRegistrationBean(
                new ServletContainer(config), 
                parseApplicationPath(jerseyProperties.getApplicationPath())
        );
        addInitParameters(registration, jerseyProperties);
        registration.setName(JerseyConfig.class.getName());
        registration.setLoadOnStartup(1);
        return registration;
    }

    private static String parseApplicationPath(String applicationPath) {
        if (!applicationPath.startsWith("/")) {
            applicationPath = "/" + applicationPath;
        }
        return applicationPath.equals("/") ? "/*" : applicationPath + "/*";
    }

    private void addInitParameters(RegistrationBean registration, JerseyProperties jersey) {
        for (Entry<String, String> entry : jersey.getInit().entrySet()) {
            registration.addInitParameter(entry.getKey(), entry.getValue());
        }
    }
}