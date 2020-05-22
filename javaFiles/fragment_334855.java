@XmlRootElement
public class PropertyObject {

    private String name;

    @XmlAttribute(name = "name")
    public String getName() {
        return name;
    }

    // There are `type` and `value` fields also, with corresponding
    // getters and setters, both using the `@XmlAttribute`
}