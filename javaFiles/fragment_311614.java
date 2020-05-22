@Bean
@ConditionalOnProperty(name="spring.mail.host")
public MailSender smtpMailSender(JavaMailSender javaMailSender) {
    SmtpMailSender mailSender = new SmtpMailSender();
    mailSender.setJavaMailSender(javaMailSender);
    return mailSender;
}