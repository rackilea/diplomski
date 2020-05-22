@XmlRootElement(name = "people")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://capabilities.nat.bt.com/xsd/manageServiceFault/2010/06/Contact/Details")
public class People2 {

    @XmlElement(name = "Address")
    @XmlElementWrapper(name = "address")
    private List<Address> addresses;

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

}