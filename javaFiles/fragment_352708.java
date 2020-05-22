import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "appels")
@XmlAccessorType(XmlAccessType.FIELD)
public class Appels implements Serializable {

    private List<Appel> appel;

}