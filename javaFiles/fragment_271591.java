import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "elements")
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class Elements extends Wrapper {

    @Override
    @XmlElement(name="element")
    public List<Element> getCollection() {
        return collection;
    }

    // No setter, to add getElements().add(element)
}