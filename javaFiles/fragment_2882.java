@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MessageType", propOrder = {
    "any"
})
public class MessageType {

    @XmlAnyElement(lax = true)
    protected Object any;

    public Object getAny() {
        return any;
    }

    public void setAny(Object value) {
        this.any = value;
    }

}