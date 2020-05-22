import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Root {

    @XmlElementRef(name="foo")
    JAXBElement<BigDecimal> foo;

    @XmlElementRef(name="bar")
    JAXBElement<BigDecimal> bar;

    @XmlElementRef(name="baz")
    JAXBElement<BigDecimal> baz;

}