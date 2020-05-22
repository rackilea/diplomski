import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Root {

    private int requestId;

    @XmlElement(name="subRequest")
    private List<SubRequest> subRequests;

}