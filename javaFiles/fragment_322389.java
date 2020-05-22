import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Root {

    @XmlElement
    private String foo;

    @XmlElement(required=true)
    private String bar;

    @XmlElement(nillable=true)
    private String baz;

}