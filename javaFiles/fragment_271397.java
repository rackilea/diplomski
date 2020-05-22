@XmlRootElement(name = "ENTRY")
@XmlAccessorType(XmlAccessType.FIELD)
public class AdaptedBaseEntry extends BaseEntry
{


    @XmlElement(name = "CODE", required = false)
    public String code;

    @XmlElement(name = "SERIAL", required = false)
    public String serial;

    public AdaptedBaseEntry()
    {
        super();
    }

    public AdaptedBaseEntry(BaseEntry entry)
    {
        super(entry.type, entry.description, entry.name);
        if (entry instanceof Machine)
        {
            this.code = ((Machine) entry).code;
        } else if (entry instanceof Robot)
        {
            this.serial = ((Robot) entry).serial;
        }
    }

}