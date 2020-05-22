@XmlAccessorType(XmlAccessType.FIELD)
public class Condition {

    @XmlAttribute(name = "name")
    private String name;

    @XmlElement(name = "li")
    private List<ListItem> listItems;

    // getters and setters
}