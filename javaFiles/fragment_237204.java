@XmlRootElement
public class Component {
    private int id;

    private Profile profile;

    private TwentySeven twentySeven;

    private Hundred hundred;

    public Hundred getHundred() {
        return hundred;
    }

    @XmlElement
    public void setHundred(Hundred hundred) {
        this.hundred = hundred;
    }

    public int getId() {
        return id;
    }

    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    /*
     * Same way add @XMLElement annotation to
     * setter methods of profile and twentySeven.
     */

}