public class MainEntity {
    private String node1;
    private String node2;
//getters and setters for all fields
}

@XmlAccessorType(XmlAccessType.FIELD)
public class ClientEntity {
    @XmlElement(name = "C_node1")
    private String C_node1;
    @XmlElement(name = "C_node2")
    private String C_node2;
    @XmlAttribute
    private Long value;
    @XmlAttribute
    private boolean use;
//getters and setters for all fields
}

@XmlAccessorType(XmlAccessType.FIELD)
public class SystemEntity {
    @XmlElement(name = "DebugFrame")
    private Long debugFrame;
//getters and setters for all fields
}