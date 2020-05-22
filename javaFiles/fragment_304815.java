package forum8198945;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Customer.class);

        Customer customer = new Customer();
        customer.setName("Alex Dean");
        customer.setCustomerReference(null);
        customer.setQuantity(1);
        customer.setCreatedAt(new Date());

        StringWriter stringWriter = new StringWriter();
        XMLOutputFactory xof = XMLOutputFactory.newFactory();
        XMLStreamWriter xsw = xof.createXMLStreamWriter(stringWriter);
        xsw = new XMLStreamWriterWrapper(xsw);
        Marshaller marshaller = jc.createMarshaller();
        marshaller.marshal(customer, xsw);

        String xml = stringWriter.toString();
        System.out.println(xml);

        XMLInputFactory xif = XMLInputFactory.newFactory();
        xif.createXMLStreamReader(new StringReader(xml));

        printValue(customer.getName());
        printValue(customer.getCustomerReference());
        printValue(customer.getQuantity());
        printValue(customer.getCreatedAt());
    }

    private static void printValue(Object value) {
        System.out.print(value);
        System.out.print(" ");
        if(null != value) {
            System.out.print(value.getClass());
        }
        System.out.println();
    }

}