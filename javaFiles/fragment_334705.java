import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    @XmlElementDecl(name="A")
    public JAXBElement<String> createA(String value) {
        return new JAXBElement<String>(new QName("A"), String.class, value);
    }

    @XmlElementDecl(name="B")
    public JAXBElement<Integer> createB(Integer value) {
        return new JAXBElement<Integer>(new QName("B"), Integer.class, value);
    }

    @XmlElementDecl(name="C")
    public JAXBElement<String> createC(String value) {
        return new JAXBElement<String>(new QName("C"), String.class, value);
    }

    @XmlElementDecl(name="D")
    public JAXBElement<String> createD(String value) {
        return new JAXBElement<String>(new QName("D"), String.class, value);
    }

}