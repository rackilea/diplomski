import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Foo {

    @XmlElementRefs({
        @XmlElementRef(name = "A", type = JAXBElement.class),
        @XmlElementRef(name = "B", type = JAXBElement.class),
        @XmlElementRef(name = "C", type = JAXBElement.class),
        @XmlElementRef(name = "D", type = JAXBElement.class)
    })
    protected JAXBElement<?> aOrBOrCOrD;

}