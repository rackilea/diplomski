@XmlRootElement(name = "User")
public class User {

    private String name;

    @XmlElement(name = "Name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}