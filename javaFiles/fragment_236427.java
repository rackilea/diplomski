import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    @XmlElementDecl(name="fooJAXBElement")
    public JAXBElement<String> createFooJAXBElement(String string) {
        return new JAXBElement<String>(new QName("fooJAXBElement"), String.class, string);
    }

    @XmlElementDecl(name="barJAXBElement")
    public JAXBElement<String> createBarJAXBElement(String string) {
        return new JAXBElement<String>(new QName("barJAXBElement"), String.class, string);
    }

}