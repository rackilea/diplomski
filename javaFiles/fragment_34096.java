import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class ResponseObject {

    private String description;
    private String email;
    private String ip_address;
    private Person person; 

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "ResponseObject{" 
                + "\n    description=" + description 
                + "\n    email=" + email 
                + "\n    ip_address=" + ip_address 
                + "\n    person=" + person 
                + "\n  }";
    }
}