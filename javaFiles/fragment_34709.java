import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SimpleSendEmail {
    public static void main(String[] args) {

        String host = "your smtp host";
        String to = "bbbb@ddddd.com";
        String from = "xxxx@yyy.com";
        String subject = "My First Email";
        String messageText = "I am sending a message using the"
                + " JavaMail API.\n" + "Here type your message.";
        boolean sessionDebug = false;
        Properties props = System.getProperties();
        props.put("mail.host", host);
        props.put("mail.transport.protocol", "smtp");
        Session session = Session.getDefaultInstance(props, null);
        // Set debug on the Session so we can see what is going on
        // Passing false will not echo debug info, and passing true
        // will.
        session.setDebug(sessionDebug);
        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = { new InternetAddress(to) };
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject);
            msg.setSentDate(new Date());
            msg.setText(messageText);

            Transport.send(msg);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}