package forum13952415;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import org.eclipse.persistence.jaxb.JAXBHelper;
import org.eclipse.persistence.oxm.XMLContext;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Customer.class);

        XMLContext xmlContext = JAXBHelper.unwrap(jc, XMLContext.class);

        Customer customer = new Customer();
        xmlContext.setValueByXPath(customer, "@id", null, 123);
        xmlContext.setValueByXPath(customer, "first-name/text()", null, "Jane");
        xmlContext.setValueByXPath(customer, "last-name/text()", null, "Doe");

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(customer, System.out);
    }

}