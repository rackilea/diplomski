@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Root {

    @XmlElement
    private String foo;  // Will be marshalled

    private String bar;  // Will not be marshalled

}