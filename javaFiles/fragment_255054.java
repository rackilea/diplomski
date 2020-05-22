@XmlAccessorType(XmlAccessType.FIELD)
public class P {

    @XmlElement(name = "Name")
    private String name;

    @XmlElement(name = "P_to_P")
    private List<P_to_P> pToPList;

    // public getters and setters (omitted for brevity)
}