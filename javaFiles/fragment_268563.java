import javax.xml.bind.annotation.*;

@XmlRootElement(namespace="http://www.w3.org/2005/Atom", name="link")
@XmlAccessorType(XmlAccessType.FIELD)
public class AtomLink {

    @XmlAttribute
    private String href;

}