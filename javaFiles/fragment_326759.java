import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Model {
    @XmlElement
    private String id;

    @XmlElement
    private List<Node> nodes;

    public Model() {
    }

    public Model(String id, List<Node> nodes) {
        this.id = id;
        this.nodes = nodes;
    }

    public String getId() {
        return id;
    }

    public List<Node> getNodes() {
        return nodes;
    }
}