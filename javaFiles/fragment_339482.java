package forum11078850;

import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlType(propOrder = { "id", "name", "email", "addresses" })
public class Employee {
    private int id;
    private String name;
    private String email;

    private List<Address> addresses;

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
    @XmlElement(name = "address")
    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

}