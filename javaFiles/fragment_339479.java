package forum11078850;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class XmlObjectFactory {

    @XmlElementDecl(scope = Employee.class, name = "address")
    JAXBElement<Address> createAddress(Address value) {
        return new JAXBElement<Address>(new QName("address"), Address.class, value);
    }

    @XmlElementDecl(name = "address")
    JAXBElement<String> createStringAddress(String value) {
        return new JAXBElement<String>(new QName("address"), String.class, value);
    }

}