import javax.xml.bind.annotation.*;
import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlAccessorType(XmlAccessType.FIELD)
public class Child {

    @XmlPath("child/@id")
    int id;

    @XmlPath("child/@name")
    String name;

}