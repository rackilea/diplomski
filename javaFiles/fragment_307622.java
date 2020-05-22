import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Data {
    @XmlAttribute
    public String name;
    @XmlElement
    public List<String> column;
}