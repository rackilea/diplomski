@XmlAccessorType(XmlAccessType.FIELD)
public class B{
    @XmlAttribute
    @XmlID
    private String id;

    @XmlIDREF
    private A a;