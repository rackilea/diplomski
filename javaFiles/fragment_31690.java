@XmlRootElement
public class Data {
    @XmlElement(nillable=true)
    public String firstName;

    @XmlElement(nillable=true)
    public String lastName;
}