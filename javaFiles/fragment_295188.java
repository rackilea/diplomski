package forum12338288;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Relation {

    @XmlAttribute
    String type;

    String name;

    @XmlElement(name="sort-name")
    String sortName;

}