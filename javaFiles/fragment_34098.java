import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResponseWrapper {
    private ResponseObject response;

    public ResponseObject getResponse() {
        return response;
    }

    public void setResponse(ResponseObject response) {
        this.response = response;
    } 

    @Override
    public String toString() {
        return "ResponseWrapper{" 
                + "\n  response=" + response
                + "\n}";
    } 
}