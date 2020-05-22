@XmlRootElement(name = "addresses", namespace = "http://jabber.org/protocol/address")
@XmlAccessorType(XmlAccessType.FIELD)
public class Addresses {

    @XmlElement
    private List<Address> address; //List of type address

    private Addresses() {
        // Private no-args default constructor for JAXB.
    }

    public Addresses(List<String> address) {
        this.address = address;
    }
}