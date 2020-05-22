@Configuration
public class MyConfiguration {

    @Bean
    public JavaMailSenderImpl mailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("mail.csonth.gov.uk");
        return mailSender;
    }

    @Bean
    public SimpleRegistrationService registrationService(JavaMailSenderImpl mailSender, VelocityEngineFactoryBean velocityEngine) {
        SimpleRegistrationService registrationService = new SimpleRegistrationService();
        registrationService.setMailSender(mailSender);
        registrationService.setVelocityEngine(velocityEngine); 
        return registrationService; 
    }

    @Bean
    public VelocityEngineFactoryBean velocityEngine() {
        VelocityEngineFactoryBean velocityEngine = new VelocityEngineFactoryBean();
        Properties velocityProperties = new Properties();
        velocityProperties.put("resource.loader", "class");
        velocityProperties.put("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        velocityEngine.setVelocityProperties(velocityProperties);
        return velocityEngine;
    }
}