@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id",
    "response"
})
@XmlRootElement(name = "createBuyerResponse")
public class BuyerResponse{

    @XmlElement(name = "id", required = true)
    protected int id;

    @XmlElement(name = "response", required = true)
    protected String response;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResponse() {
        return this.response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}