@Autowired
private MailSender mailSender;

JavaMailSenderImpl jms = mailService.createMailSender();
MimeMessage mimeMessage = new MimeMessage(mailService.getMailSession(jms));
MimeMessageHelper message = null;
message.setSubject("Test mail");
message.setTo("email@domain.com");
message.setText(htmlContent, true);
Transport.send(message);