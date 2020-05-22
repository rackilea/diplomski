import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class MailSender {
  public static void send (String to,String message1,String subject,String ss)
      throws Exception {
    String host ="smtp.gmail.com";
    String from="from@gmail.com";
    String password="Your password";
    Properties props = System.getProperties();

  props.put("mail.transport.protocol", "smtps");
  props.put("mail.smtp.user", from);
  props.put("mail.smtp.password", password);
  props.put("mail.smtp.port", "465");
  props.put("mail.smtps.auth", "true");
  props.put("mail.smtp.starttls.enable","true");

    props.put("mail.smtp.host", host);

    Session session = Session.getInstance(props, null);


    MimeMessage message = new MimeMessage(session);
    message.setFrom( new InternetAddress(from));
    message.addRecipient( Message.RecipientType.TO, new InternetAddress(to));
    message.setSubject(subject);
    message.setText(message1);



    Transport transport = session.getTransport("smtps");
    transport.connect(host,from, password);
    transport.sendMessage(message, message.getAllRecipients());
    System.out.println("mail has been sent");
}


  public static void main(String arg[]) throws Exception
  {

      MailSender m=new MailSender();
      m.send("to@gmail.com", "hello ..", "test mail...","");
  }
  }