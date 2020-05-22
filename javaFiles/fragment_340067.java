@Configuration
public class MailConfig {
    @Bean
    public SmtpkMailSender getSmtpkMailSender(){
        return new SmtpkMailSender();
    }

    @Bean
    @Primary
    public MockMailSender getMockMailSender(){
        return new MockMailSender();
    }
}