@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Root {
    @XmlElement
    private String fieldInRoot;
    @XmlElementRef
    private BodyResponse child;
    // + getters and setters
}