@XmlAccessorType(XmlAccessType.FIELD)
public class List {

    @XmlAttribute(name="name")
    public String name;

    @XmlElement(name = "list")
    public List nestedList;

    @XmlElement(name = "property")
    public List<Property> properties;
...
}