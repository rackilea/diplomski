@Configuration
@Profile("prod")
@PropertySource("file:///${user.home}/.devopsbuddy/application-prod.properties")
public class ProductionConfig {

@Bean
public EmailService emailService() {
    return new SmtpEmailService();
}
}