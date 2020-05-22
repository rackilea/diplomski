@XmlRootElement    
@XmlAccessorType(XmlAccessType.FIELD)
public class Wrapper {
    @XmlElement
    protected String baz;

    @XmlElement(name = "bar")
    @XmlElementWrapper(name = "foo")
    protected List<String> bars;

    public String getBaz() {
        return baz;
    }

    public void setBaz(String baz) {
        this.baz = baz;
    }

    public List<String> getBars() {
        return bars;
    }

    public void setBars(List<String> bars) {
        this.bars = bars;
    }
}