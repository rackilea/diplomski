@Bean
public SimpleRegistrationService registrationService(JavaMailSenderImpl mailSender, VelocityEngineFactoryBean velocityEngine) {
    SimpleRegistrationService registrationService = new SimpleRegistrationService();
    registrationService.setMailSender(mailSender);
    registrationService.setVelocityEngine(velocityEngine.getObject()); // <--- getObject
    return registrationService;
}