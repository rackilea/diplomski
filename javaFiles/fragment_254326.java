import java.util.List;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Response {

    @XmlElementWrapper(name = "Info")
    @XmlElement(name = "Person")
    private List<Person> person;

    @XmlAttribute
    private String target;

}