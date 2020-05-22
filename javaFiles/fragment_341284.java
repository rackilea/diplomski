import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.dom4j.Document;
import org.dom4j.io.DocumentResult;

public class Demo {

    public static void main(String[] args) throws Exception {
        // Create the JAXBContext
        JAXBContext jc = JAXBContext.newInstance(Customer.class);

        // Create the POJO
        Customer customer = new Customer();
        customer.setName("Jane Doe");

        // Marshal the POJO to a DOM4J DocumentResult
        Marshaller marshaller = jc.createMarshaller();
        DocumentResult dr = new DocumentResult();
        marshaller.marshal(customer, dr);

        // Manipulate the resulting DOM4J Document object
        Document document = dr.getDocument();
        document.getRootElement().addAttribute("foo", "bar");

        // Output the result
        System.out.println(document.asXML());
    }

}