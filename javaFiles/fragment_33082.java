// yes you need to use this package as SmartMimeMessage is package-private or you loose spring advantages
package org.springframework.mail.javamail;

import javax.activation.FileTypeMap;
import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

/**
 * Created for http://stackoverflow.com/q/22860793/1266906
 */
public class RoutedSmartMimeMessage extends SmartMimeMessage {
    private Address[] rcptTo = null;

    /**
     * Create a new SmartMimeMessage.
     *
     * @param session
     *         the JavaMail Session to create the message for
     * @param defaultEncoding
     *         the default encoding, or {@code null} if none
     * @param defaultFileTypeMap
     *         the default FileTypeMap, or {@code null} if none
     */
    public RoutedSmartMimeMessage(final Session session,
                                  final String defaultEncoding,
                                  final FileTypeMap defaultFileTypeMap) {
        super(session, defaultEncoding, defaultFileTypeMap);
    }

    public Address[] getRcptTo() {
        return rcptTo;
    }

    public void setRcptTo(final Address... rcptTo) {
        this.rcptTo = rcptTo;
    }

    @Override
    public Address[] getAllRecipients() throws MessagingException {
        if(rcptTo != null) {
            return rcptTo;
        } else {
            return super.getAllRecipients();
        }
    }

    public static MimeMessage createMesage(final JavaMailSenderImpl javaMailSender) {
        return new SmartMimeMessage(javaMailSender.getSession(), javaMailSender.getDefaultEncoding(), javaMailSender.getDefaultFileTypeMap());
    }
}