import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.ZonedDateTime;

public class JaxbApp {

    public static void main(String[] args) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(EmailList.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        EmailBody emailBody = new EmailBody();
        emailBody.setTitle("This is test Title : " + ZonedDateTime.now());
        emailBody.setBody("");

        EmailList emailList = new EmailList();
        emailList.setTemplateId(1);
        emailList.setCampaignId(100);
        emailList.setCampaignName("Test Campaign Using XML DS");
        emailList.setCategory("Trigger");
        emailList.setEmail("test@test.com.my");
        emailList.setSubject("Transactional Submissions");
        emailList.setSenderEmail("test@test.com.my");
        emailList.setEmailBody(emailBody);

        marshaller.marshal(emailList, System.out);
    }
}

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "EMAILLIST", namespace = "TransactionalSubmissionsSvcs")
class EmailList {

    @XmlElement(name = "TemplateID")
    private int templateId;

    @XmlElement(name = "CampaignID")
    private int campaignId;

    @XmlElement(name = "CampaignName")
    private String campaignName;

    @XmlElement(name = "Category")
    private String category;

    @XmlElement(name = "Email")
    private String email;

    @XmlElement(name = "Subject")
    private String subject;

    @XmlElement(name = "SenderEmail")
    private String senderEmail;

    @XmlElement(name = "EmailBody")
    private EmailBody emailBody;

    // getters, setters
}

class EmailBody {

    private String title;
    private String body;

    // getters, setters
}