import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Foo {

    @XmlElementRef(name="bar")
    private JAXBElement<Bar> bar;

}