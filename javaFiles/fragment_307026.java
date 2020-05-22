package forum13232991;

import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Value {

    @XmlAttribute
    String type;

    @XmlMixed
    List<String> value;

    @XmlElement(name="component")
    List<Component> components;

}