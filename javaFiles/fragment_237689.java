import java.util.List;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Root {

   @XmlElement(name="parent")
   @XmlJavaTypeAdapter(ChildAdapter.class)
   List<Child> allChildren;

}