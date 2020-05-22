import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

    @XmlElementDecl(name="ResponseCode")
    public JAXBElement<String> createResponseCode(String string) {
        return new JAXBElement<String>(new QName("ResponseCode"), String.class, string);
    }

    @XmlElementDecl(name="ResultCode")
    public JAXBElement<String> createResultCode(String string) {
        return new JAXBElement<String>(new QName("ResultCode"), String.class, string);
    }

}