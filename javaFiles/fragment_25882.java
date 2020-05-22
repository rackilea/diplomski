import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "users")
public class UserListWrapper {

    private List<User> persons;

    @XmlElement(name = "user")
    public List<User> getPersons() {
        return persons;
    }

    public void setPersons(List<User> persons) {
        this.persons = persons;
    }
}