import javax.xml.bind.annotation.*;

@XmlRootElement(name="ROOT")
@XmlAccessorType(XmlAccessType.FIELD)
public class Root {

    @XmlElement(name="ELEM_A")
    private ElemA elemA;

    @XmlElement(name="ELEM_B")
    private ElemB elemB;

}