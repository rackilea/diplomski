@XmlRootElement(name = "template")
@XmlAccessorType(XmlAccessType.FIELD)
public class Template {

    @XmlElement(name = "condition")
    private Condition condition;

    // getters and setters
}