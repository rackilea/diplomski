@Component
public class MailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail(String covere) throws MailException{

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo("yottiallipierre@gmail.com");
        mail.setFrom("yottiallipierre@gmail.com");
        mail.setSubject("Test");
        mail.setText(covere);
        javaMailSender.send(mail);
    }

}