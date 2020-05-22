import javax.mail.*;
import javax.mail.internet.*;

// Set up the SMTP server.
java.util.Properties props = new java.util.Properties();
props.put("mail.smtp.host", "smtp.myisp.com");
Session session = Session.getDefaultInstance(props, null);

// Construct the message
String to = "you@you.com";
String from = "me@me.com";
String subject = "Hello";
Message msg = new MimeMessage(session);
try {
    msg.setFrom(new InternetAddress(from));
    msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
    msg.setSubject(subject);
    msg.setText("Hi,\n\nHow are you?");

    // Send the message.
    Transport.send(msg);
} catch (MessagingException e) {
    // Error.
}