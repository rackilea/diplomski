@XmlRootElement(name="query")
@XmlAccessorType(XmlAccessType.FIELD)
public class Query {

    @XmlElementWrapper
    @XmlElement(name="rate")
    private List<Rate> results;

    public List<Rate> getRate() {
        return results;
    }

    public void setRate(List<Rate> rate) {
        this.results = rate;
    }
}