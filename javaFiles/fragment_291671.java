import java.util.List;
import javax.xml.bind.annotation.*;
import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "name", propOrder = { "tag4", "id" })
public class newBean {

    @XmlPath("tag4/@id")
    List<String> id;

}