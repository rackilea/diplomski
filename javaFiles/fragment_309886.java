import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Root.class);

        Root root = new Root();
        root.setFoo(DatatypeConverter.parseDateTime("2013-08-02T11:50:00-04:00").getTime());
        root.setBar(DatatypeConverter.parseDateTime("2013-08-02T11:50:00.123-04:00").getTime());

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(root, System.out);
    }

}