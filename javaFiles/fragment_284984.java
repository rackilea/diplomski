import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class SendMail {
    public static sendMail(String from, String to, String subject, String body)
        throws MessagingException
    {
        final Properties p = new Properties();
        p.put("mail.smtp.host", "localhost");
        final Message msg = new MimeMessage(Session.getDefaultInstance(p));
        msg.setFrom(new InternetAddress(from));
        msg.addRecipient(RecipientType.TO, new InternetAddress(to));
        msg.setSubject(subject);
        msg.setText(body);
        Transport.send(msg);
    }
}