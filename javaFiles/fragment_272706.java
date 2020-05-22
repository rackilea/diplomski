@XmlRootElement(name = "user")
public class User {

    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    @XmlElement(name = "first.name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}