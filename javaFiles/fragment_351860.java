package modules;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CollaborationInfo", propOrder = {
    "AgreementRef",
    "ConversationId"
})
public class CollaborationInfo {

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class AgreementRef {
        @XmlAttribute
        private String pmode;

        public String getPmode() {
            return pmode;
        }
        public void setPmode(String pmode) {
            this.pmode = pmode;
        }
    }

    @XmlElement(name = "AgreementRef")
    protected AgreementRef AgreementRef = new AgreementRef();

    @XmlElement(name="ConversationId")
    protected String ConversationId;


    public String getPmode() {
        return AgreementRef.getPmode();
    }

    public void setPmode(String value) {
        this.AgreementRef.setPmode(value);
    }


    public String getConversationId() {
        return ConversationId;
    }
    public void setConversationId(String value) {
        this.ConversationId = value;
    }
}