import java.util.List;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.w3c.dom.Element;

@XmlRootElement
public class Categories {

    private List<Element> keys;

    @XmlAnyElement
    public List<Element> getKeys() {
        return keys;
    }

    public void setKeys(List<Element> keys) {
        this.keys = keys;
    }

}