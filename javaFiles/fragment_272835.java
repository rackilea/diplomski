import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Address {

    private String street;

    @XmlElement(nillable=true)
    private String city;

}