@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class Root {
    private MainEntity main;
    @XmlElement(name = "client")
    private List<ClientEntity> clients;
    @XmlAttribute
    private String a;
    @XmlElement(name = "System")
    private SystemEntity system;
//getters and setters for all fields
}