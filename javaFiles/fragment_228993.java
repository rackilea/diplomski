import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Notifications {

    private String date;

    @XmlPath("subject/@creditcard_num")
    private String creditcardNum;

    @XmlPath("subject/@checknum")
    private String checknum;

    private String subject;

    @XmlPath("body/@payment_amount")
    private String paymentAmount;

    @XmlPath("body/@return_status")
    private String returnStatus;

    private String body;

}