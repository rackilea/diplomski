import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created for http://stackoverflow.com/q/22860793/1266906
 */
public class Mailing {
    public static void main(String[] args) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("HOST");
        mailSender.setPort(25);
        mailSender.setUsername("USERNAME");
        mailSender.setPassword("PASSWORD");

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        try {
            /*
            Not needed
            mimeMessage.setRecipient(MimeMessage.RecipientType.TO,
                                     new InternetAddress("user-signup-123123123@bounces.example.com"));
             */

            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setTo("+10xxxxxxxxxx");

            sendMail(mailSender, mimeMessage, new InternetAddress("user-signup-123123123@bounces.example.com"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Adopted from {@link org.springframework.mail.javamail.JavaMailSenderImpl#doSend(javax.mail.internet.MimeMessage[], Object[])} to be able to call {@link javax.mail.Transport#send(javax.mail.Message, javax.mail.Address[])} with a different second parameter than {@link javax.mail.Message#getAllRecipients() mimeMessage.getAllRecipients()}
     *
     * @param javaMailSender
     *         JavaMailSender object holding configuration options
     * @param mimeMessage
     *         MimeMessage object to send
     * @param realRecipients
     *         RCPT TO: sddresses
     * @throws org.springframework.mail.MailAuthenticationException
     *         in case of authentication failure
     * @throws org.springframework.mail.MailSendException
     *         in case of failure when sending a message
     */
    private static void sendMail(final JavaMailSenderImpl javaMailSender,
                                 final MimeMessage mimeMessage,
                                 final Address... realRecipients) throws MailException {
        final Map<Object, Exception> failedMessages = new LinkedHashMap<Object, Exception>();

        final Transport transport;
        try {
            Session session = javaMailSender.getSession();
            String protocol = javaMailSender.getProtocol();
            if (protocol == null) {
                protocol = session.getProperty("mail.transport.protocol");
                if (protocol == null) {
                    protocol = JavaMailSenderImpl.DEFAULT_PROTOCOL;
                }
            }
            transport = session.getTransport(protocol);
            transport.connect(javaMailSender.getHost(),
                              javaMailSender.getPort(),
                              javaMailSender.getUsername(),
                              javaMailSender.getPassword());
        } catch (AuthenticationFailedException ex) {
            throw new MailAuthenticationException(ex);
        } catch (MessagingException ex) {
            failedMessages.put(mimeMessage, ex);
            throw new MailSendException("Mail server connection failed", ex, failedMessages);
        }

        try {
            try {
                if (mimeMessage.getSentDate() == null) {
                    mimeMessage.setSentDate(new Date());
                }
                String messageId = mimeMessage.getMessageID();
                mimeMessage.saveChanges();
                if (messageId != null) {
                    // Preserve explicitly specified message id...
                    mimeMessage.setHeader("Message-ID", messageId);
                }
                transport.sendMessage(mimeMessage, realRecipients);
            } catch (MessagingException ex) {
                failedMessages.put(mimeMessage, ex);
            }
        } finally {
            try {
                transport.close();
            } catch (MessagingException ex) {
                if (!failedMessages.isEmpty()) {
                    throw new MailSendException("Failed to close server connection after message failures", ex,
                                                failedMessages);
                } else {
                    throw new MailSendException("Failed to close server connection after message sending", ex);
                }
            }
        }

        if (!failedMessages.isEmpty()) {
            throw new MailSendException(failedMessages);
        }
    }
}