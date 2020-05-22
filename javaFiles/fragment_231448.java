public class EmailNotifier {
private JavaMailSenderImpl mailSender;

public void setMailSender(JavaMailSenderImpl mailSender) {
    this.mailSender = mailSender;
}

public void sendMail(InternetAddress fromAddress, InternetAddress toAddress, String subject, String msg) {

    MimeMessage message = mailSender.createMimeMessage();

    try {
        // use the true flag to indicate you need a multipart message
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom(fromAddress);
        helper.setTo(toAddress);
        helper.setSubject(subject);
        helper.setText(msg);
        // let's attach the infamous windows Sample file (this time copied to c:/)
        FileSystemResource file = new FileSystemResource(new File("c:/test.xls"));
        helper.addAttachment("test.xls", file);
        mailSender.send(message);
    } catch (MessagingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }           
}
}