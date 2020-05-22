@XmlRootElement(name = "TrafficHistoryResponse", namespace="http://alexa.amazonaws.com/doc/2005-10-05/")
public class AlexaResult implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -3068403572663448394L;


    private AlexaResponse alexaResponse;

    @XmlElement(name="Response")
    public AlexaResponse getAlexaResponse() {
        return alexaResponse;
    }

    public void setAlexaResponse(AlexaResponse alexaResponse) {
        this.alexaResponse = alexaResponse;
    }

}