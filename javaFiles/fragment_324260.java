import javax.xml.bind.annotation.*;
import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlRootElement(name="root")
@XmlAccessorType(XmlAccessType.FIELD)
public class Response{
    @XmlPath("record/AddressDetails/street/text()")
    String street; 

    //getter and setters
}