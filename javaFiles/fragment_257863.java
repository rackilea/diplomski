@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ErrorMessage {

    /** contains the same HTTP Status code returned by the server */
    @XmlElement(name = "status")
    int status;