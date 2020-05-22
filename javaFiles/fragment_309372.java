import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "person")
public class Person {
    public String firstName; 
    public String lastName;
    @XmlElementWrapper(name = "identities")
    @XmlElementRef
    public Set<Identity> identities = new HashSet<Identity>();
}