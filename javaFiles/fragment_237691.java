import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Root {

   @XmlElement(name="parent")
   List<Child> allChildren;

}