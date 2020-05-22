import java.io.File;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(AlexaResult.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        File xml = new File("input.xml");
        AlexaResult result = (AlexaResult) unmarshaller.unmarshal(xml);
        System.out.println(result.getAlexaResponse().getAlexaHistoryResult());
    }

}