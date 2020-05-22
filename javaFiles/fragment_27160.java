@XmlRootElement(name = "User")
public class User {

    @XmlTransient
    public String name;

    @XmlElement(name = "Name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}