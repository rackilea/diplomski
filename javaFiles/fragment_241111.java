import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlType(propOrder={"name", "address"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer {

    private String name;
    private Address address;

    public Customer() {
    }

    public Customer(String name, Address address) {
        this.name = name;
        this.address = address;
    }

}