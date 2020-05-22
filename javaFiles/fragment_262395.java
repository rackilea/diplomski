@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Domain {

    @XmlElement
    private int id;
    @XmlElement
    private String name;
    // Getters and Setters
}

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Domains {

    @XmlElementRef(name = "domain")
    private List<Domain> domains;
    // Getter and Setters
}