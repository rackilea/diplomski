import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBIntrospector;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.namespace.QName;

public class Demo {


    public static void main(String[] args) throws Exception {
        Object value = "Hello World";
        //Object value = new Bar();

        JAXBContext jc = JAXBContext.newInstance(String.class, Bar.class);
        JAXBIntrospector introspector = jc.createJAXBIntrospector();
        Marshaller marshaller = jc.createMarshaller();
        if(null == introspector.getElementName(value)) {
            JAXBElement jaxbElement = new JAXBElement(new QName("ROOT"), Object.class, value);
            marshaller.marshal(jaxbElement, System.out);
        } else {
            marshaller.marshal(value, System.out);
        }
    }

    @XmlRootElement
    public static class Bar {

    }

}