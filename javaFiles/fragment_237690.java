import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Child {

    @XmlAttribute
    int id;

    @XmlAttribute
    String name;

}