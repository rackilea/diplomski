@XmlRootElement(name = "User")
public class User {

    @XmlTransient
    public String name;

    @XmlTransient
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}