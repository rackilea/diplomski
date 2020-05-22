@XmlRootElement( name = "rate" )
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rate", propOrder = {
        "rate"
    })
public class Rate {

    @XmlAttribute(name="id")
    private String id;

    @XmlElement(name="Rate")
    private String rate;

    public String getId() {
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }


}