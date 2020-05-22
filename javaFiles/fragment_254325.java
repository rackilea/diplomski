import javax.xml.bind.annotation.*;

@XmlRootElement(name="WebResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class WebResponse {

    @XmlElement(name = "Response")
    private Response response = null;

}