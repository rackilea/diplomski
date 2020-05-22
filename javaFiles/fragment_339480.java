package forum11078850;

import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlType(propOrder = { "id", "name", "email", "addresses" })
public class Employee {
    private int id;
    private String name;
    private String email;

    private List<JAXBElement<Address>> addresses;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlElementWrapper
     @XmlElementRef(name="address")
    public List<JAXBElement<Address>> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<JAXBElement<Address>> addresses) {
        this.addresses = addresses;
    }

}