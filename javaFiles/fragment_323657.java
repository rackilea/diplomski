// VelocityEngine as parameter type, not VelocityEngineFactoryBean
@Bean
public SimpleRegistrationService registrationService(JavaMailSenderImpl mailSender, VelocityEngine velocityEngine) { 
    SimpleRegistrationService registrationService = new SimpleRegistrationService();
    registrationService.setMailSender(mailSender);
    registrationService.setVelocityEngine(velocityEngine); // <-- no getObject() needed
    return registrationService;
}