import org.apache.commons.mail.*;

public class GmailEmailWorking {

    public static void main(String[] args) {
        String myEmailId = "xyz@gmail.com";
        String myPassword = "password";
        String senderId = "xyz@yahoo.com";
        try {
            MultiPartEmail email = new MultiPartEmail();
            email.setSmtpPort(587);
            email.setAuthenticator(new DefaultAuthenticator(myEmailId, myPassword));
            email.setDebug(true);
            email.setHostName("smtp.gmail.com");
            email.setFrom(myEmailId);
            email.setSubject("Hi");
            email.setMsg("This is a test mail ... :-)\n\nPlease check attachements that I have sent.\n\nThanks,\nFahim");
            email.addTo(senderId);
            email.setTLS(true);

            EmailAttachment attachment = new EmailAttachment();
            attachment.setPath("/Users/fahadparkar/Desktop/Fahim/tables.xlsx");
            attachment.setDisposition(EmailAttachment.ATTACHMENT);
            attachment.setDescription("Excel");
            attachment.setName("tables.xlsx");
            email.attach(attachment);

            email.send();
            System.out.println("Mail sent!");
        } catch (Exception e) {
            System.out.println("Exception :: " + e);
        }
    }
}