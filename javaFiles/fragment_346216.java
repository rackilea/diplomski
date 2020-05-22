package forum383861;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {

    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}