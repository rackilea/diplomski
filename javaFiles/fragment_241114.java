import javax.xml.bind.*;
import javax.xml.stream.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Customer.class);

        Address address = new Address("123 A Street");
        Customer customer = new Customer("Jane", address);

        XMLOutputFactory xof = XMLOutputFactory.newFactory();
        XMLStreamWriter xsw = xof.createXMLStreamWriter(System.out);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setListener(new MyMarshallerListener(xsw));
        marshaller.marshal(customer, xsw);
        xsw.close();;
    }

}