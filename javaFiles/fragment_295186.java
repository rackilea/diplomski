package forum12338288;

import java.util.*;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Work {

    @XmlElement(name="relation-list")
    List<RelationList> relationList = new ArrayList<RelationList>();

}