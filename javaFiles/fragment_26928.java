@XmlAccessorType(XmlAccessType.FIELD)
public class Pool {
    @XmlElement(name = "prize")
    @XmlElementWrapper(name = "poolPrizes")
    protected List<Prize> poolPrizes;
    @XmlElement(name = "event")
    private List<Event> events;  
    @XmlAttribute
    protected String id;
    @XmlAttribute
    protected String name;
    @XmlAttribute
    protected String poolType;
    @XmlAttribute
    protected String closesAt;
    @XmlAttribute
    protected String displayOrder;
    @XmlAttribute
    protected String resulted;
    @XmlAttribute
    protected String lastUpdateDate;
    @XmlAttribute
    protected String lastUpdateTime;
    // GETTER and SETTERS
}