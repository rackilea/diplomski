import java.io.File;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(ResponseAPI.class, ObjectFactory.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("Scratch/src2/forum24554789/input.xml");
        ResponseAPI responseAPI = (ResponseAPI) unmarshaller.unmarshal(xml);

        ObjectFactory objectFactory = new ObjectFactory();
        String responseCode = responseAPI.getResponseCode().getValue();
        JAXBElement<String> resultCodeJAXBElement = objectFactory.createResultCode(responseCode);
        responseAPI.setResponseCode(resultCodeJAXBElement);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(responseAPI, System.out);
    }

}