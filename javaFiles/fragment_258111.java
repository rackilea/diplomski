import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseAPI{

    @XmlElementRefs({
        @XmlElementRef(name = "ResponseCode"),
        @XmlElementRef(name = "ResultCode")
    })
    private JAXBElement<String> responseCode;

    public JAXBElement<String> getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(JAXBElement<String> responseCode) {
        this.responseCode = responseCode;
    }

}