package forum12338288;

import java.util.List;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class RelationList {

    @XmlAttribute(name="target-type")
    String targetType;

    List<Relation> relation;

}