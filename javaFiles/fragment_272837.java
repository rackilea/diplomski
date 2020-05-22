import javax.xml.bind.annotation.*;
import org.eclipse.persistence.oxm.annotations.XmlCustomizer;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlCustomizer(AddressCustomizer.class)
public class Address {

    private String street;

    @XmlElement(nillable=true)
    private String city;

}