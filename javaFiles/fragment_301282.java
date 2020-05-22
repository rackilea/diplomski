import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class MyMailSender {

    public void sendMail(String to, String from, String subject, String msg) throws EmailException {
       Email email = new SimpleEmail();
       email.addTo(to);
       email.setFrom(from);
       email.setSubject(subject);   
       email.setMsg(msg);
       email.setHostName("testmail.com");   
       email.send();  
    }

}