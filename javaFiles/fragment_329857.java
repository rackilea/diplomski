import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailTLS {

public static void main(String[] args) {

    final String username = "username@gmail.com";
    final String password = "password";

    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");

    Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {

                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

    try {

        // Define message
        MimeMessage message =
                new MimeMessage(session);
        message.setFrom(
                new InternetAddress(from));
        message.addRecipient(
                Message.RecipientType.TO,
                new InternetAddress(to));
        message.setSubject(
                "Hello JavaMail Attachment");

        // create the message part 
        MimeBodyPart messageBodyPart =
                new MimeBodyPart();

        //fill message
        messageBodyPart.setText("Hi");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);

        // Part two is attachment
        messageBodyPart = new MimeBodyPart();
        DataSource source =
                new FileDataSource(fileAttachment);
        messageBodyPart.setDataHandler(
                new DataHandler(source));
        messageBodyPart.setFileName(fileAttachment);
        multipart.addBodyPart(messageBodyPart);

        // Put parts in message
        message.setContent(multipart);

        // Send the message
        Transport.send(message);


    } catch (Exception e) {
        e.printStackTrace();
    }
}