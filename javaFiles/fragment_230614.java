@Autowired
public JavaMailSender emailSender;

public void sendSimpleMessage(
  String to, String subject, String text) {
    SimpleMailMessage message = new SimpleMailMessage(); 
    message.setTo(to); 
    message.setSubject(subject); 
    message.setText(text);
    emailSender.send(message);
}