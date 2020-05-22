@XmlRootElement(name = "Person", namespace = "http://example.org")
public class Person {
    @XmlElement(name = "Name", namespace = "http://example.org")
    private String name;
    @XmlElement(name = "Address", namespace = "http://example.org")
    private Address address;

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }
}