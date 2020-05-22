import java.io.File;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(XmlConf.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("src/forum16762200/input.xml");
        XmlConf xmlConf = (XmlConf) unmarshaller.unmarshal(xml);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(xmlConf, System.out);
    }

}