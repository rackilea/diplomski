@Service
public class SendEmailService {

   @Autowired
   @Setter //using lombok
   private JavaMailSenderImpl mailSender;

   public void send(String to, String subject, String text){

       SimpleMailMessage message = new SimpleMailMessage();
       message.setTo(to);
       message.setSubject(subject);
       message.setText(text);
       mailSender.send(message);
   }
}