@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Oxip {
    @XmlElement
    protected Response response;
    @XmlAttribute
    protected String id;
    @XmlAttribute
    protected String created;
    @XmlAttribute
    protected String lastMsgId;
    @XmlAttribute
    protected String requestTime;
    // GETTER and SETTERS
}