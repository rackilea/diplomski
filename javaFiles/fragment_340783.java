@XmlRootElement(name = "CURRENT_VALUES")
@XmlAccessorType(XmlAccessType.FIELD)
public class EventoModel 
{
    @XmlElement
    private Item agency;

    @XmlElement
    private Item company;

    @XmlElement
    private Item channel;

    // public getters and setters (omitted here for brevity)
}