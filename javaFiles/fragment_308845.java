import java.io.File;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.util.JAXBSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

public class Demo {

    public static void main(String[] args) throws Exception {
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI); 
        Schema schema = sf.newSchema(new File("customer.xsd")); 

        JAXBContext jc = JAXBContext.newInstance(Customer.class);

        Customer customer = new Customer();
        // populate the customer object
        JAXBSource source = new JAXBSource(jc, customer);
        schema.newValidator().validate(source);
    }

}