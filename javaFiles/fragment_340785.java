@XmlAccessorType(XmlAccessType.FIELD)
public class Value {

    @XmlAttribute(namespace = "http://www.w3.org/2001/XMLSchema-instance")
    private String type;

    @XmlValue
    private String text;

    // public getters and setters (omitted here for brevity)
}