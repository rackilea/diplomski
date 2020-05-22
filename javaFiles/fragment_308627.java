import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class AdreseCompleteType {

    @XmlElement(name = "InHouseMail")
    protected UdtTextType inHouseMail;

    public void setInHouseMail(UdtTextType inHouseMail) {
        this.inHouseMail = inHouseMail;
    }

}