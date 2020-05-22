@XmlRootElement(name = "Entries")
@XmlAccessorType(XmlAccessType.FIELD)
public class Entries {

    @XmlElement(name="Entries")
    private List<Entry> entryList = new ArrayList<Entry>();

    public List<Entry> getEntryList() {
        return entryList;
    }