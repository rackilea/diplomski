@XmlAccessorType(XmlAccessType.FIELD)
public class Response {
    @XmlAttribute
    protected String request;
    @XmlAttribute
    protected String code;
    @XmlAttribute
    protected String message;
    @XmlAttribute
    protected String debug;
    @XmlAttribute
    protected String provider;
    @XmlElement
    protected Disclaimer disclaimer;
    @XmlElement
    protected Pool pool;
    // GETTERS and SETTERS
}