@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public abstract class Message {
 ....
 @XmlAnyElement(lax=false)
 private Object value;
 ....