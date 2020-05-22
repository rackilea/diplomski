@XmlRootElement(name = "User")
public class User {

    private String name;

    @XmlTransient
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}