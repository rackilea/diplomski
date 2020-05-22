package forum11193953;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Mapping {


    @XmlElement(name ="class-a")
    private String classA;

    @XmlElement(name = "class-b")
    private String classB;

}