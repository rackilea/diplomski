package forum11193953;

import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="mappings") // Match the root element "mappings"
@XmlAccessorType(XmlAccessType.FIELD)
public class Mappings {

    @XmlElement(name="mapping") // There will be a "mapping" element for each item.
    private List<Mapping> mappingEntries = null;

}