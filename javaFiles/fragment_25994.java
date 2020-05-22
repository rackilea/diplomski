import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class JaxbApp {

    public static void main(String[] args) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(ElementName.class);

        ElementName en = new ElementName();
        en.attribute1 = "A";
        en.attribute2 = "B";
        en.value = null;

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.marshal(en, System.out);
    }
}

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ElementName")
class ElementName {

    @XmlElement(name = "ElementName")
    protected String value;
    @XmlAttribute(name = "attribute1")
    protected String attribute1;
    @XmlAttribute(name = "attribute2")
    protected String attribute2;
}