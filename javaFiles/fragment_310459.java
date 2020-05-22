@XmlAccessorType(XmlAccessType.FIELD)
public class ListItem {

    @XmlAttribute(name = "value")
    private String value;

    @XmlElement(name = "condition")
    private Condition condition;

    // getters and setters
}