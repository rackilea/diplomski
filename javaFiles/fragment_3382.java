import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Commission implements Fee {

    @XmlAttribute
    private String name;

    @XmlAttribute
    private String rate;

}