import javax.xml.bind.annotation.*;
import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "name", propOrder = { "tag4", "id" })
public class newBean {

    @XmlElement(required=true)
    String tag4;

    @XmlPath("tag4/@id")
    String id;

}