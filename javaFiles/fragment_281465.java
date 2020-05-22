package blog.immutable.adpater;

import javax.xml.bind.annotation.XmlAttribute;
import blog.immutable.Address;

public class AdaptedCustomer {

    private String name;
    private Address address;

    @XmlAttribute
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}