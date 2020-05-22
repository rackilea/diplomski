import javax.xml.bind.annotation.*;


@XmlRootElement(name="node")
@XmlAccessorType(XmlAccessType.FIELD)
public class Payload {
    @XmlAttribute(name = "id")
    String id; // for example
}