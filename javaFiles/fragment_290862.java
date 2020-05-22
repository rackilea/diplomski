@XmlRootElement(name = "address")
@XmlAccessorType(XmlAccessType.FIELD)
public class Address {

    @XmlAttribute
    private String to = 'to';

    @XmlAttribute
    private String jid;

    private Address() {
        // Private no-args default constructor for JAXB.
    }

    public Address(String jid) {
        this.jid = jid;
    }
}