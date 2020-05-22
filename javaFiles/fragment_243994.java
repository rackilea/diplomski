import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    @XmlElementDecl(name = "foo")
    public JAXBElement<BigDecimal> createFoo(BigDecimal value) {
        return new JAXBElement<BigDecimal>(new QName("foo"), BigDecimal.class, value);
    }

    @XmlElementDecl(name = "bar")
    public JAXBElement<BigDecimal> createBar(BigDecimal value) {
        return new JAXBElement<BigDecimal>(new QName("bar"), BigDecimal.class, value);
    }

    @XmlElementDecl(name = "baz")
    public JAXBElement<BigDecimal> createBaz(BigDecimal value) {
        return new JAXBElement<BigDecimal>(new QName("baz"), BigDecimal.class, value);
    }

}