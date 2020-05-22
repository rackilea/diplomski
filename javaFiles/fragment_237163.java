import java.net.URL;
import java.util.*;
import javax.xml.bind.annotation.*;
import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlRootElement(name = "XmlSource")
@XmlType(propOrder={"parameters", "urlp", "path"})
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlConf {

    @XmlAttribute(name="URL")
    private URL url;

    private List<String> path = new ArrayList<String>();

    @XmlElement(name="urlPath")
    private String urlp;

    @XmlPath("hostName/parameters")
    private Map<String, String> parameters;

    @XmlPath("hostName/@name")
    private String host;

}