import java.io.File;
import javax.xml.XMLConstants;
import javax.xml.bind.*;
import javax.xml.validation.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Root.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();

        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI); 
        Schema schema = sf.newSchema(new File("src/forum28584265/schema.xsd")); 
        unmarshaller.setSchema(schema);

        SubRequestValidator subRequestValidator = new SubRequestValidator();
        unmarshaller.setListener(subRequestValidator);
        unmarshaller.setEventHandler(subRequestValidator);

        File xml = new File("src/forum28584265/input.xml");
        Root root = (Root) unmarshaller.unmarshal(xml);
    }

}