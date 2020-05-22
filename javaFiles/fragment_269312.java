import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class MyAdapter extends XmlAdapter<String, Object> {

    private static int counter = 1; 

    private static JAXBContext jaxbContext;
    static {
        try {
            jaxbContext = JAXBContext.newInstance(A.class, B.class, C.class);
        } catch(JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object unmarshal(String v) throws Exception {
        File xml = new File(v);
        return jaxbContext.createUnmarshaller().unmarshal(xml);
    }

    @Override
    public String marshal(Object v) throws Exception {
        String filename = counter++ + ".xml";
        File xml = new File(filename);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(v, xml);
        return filename;
    }

}