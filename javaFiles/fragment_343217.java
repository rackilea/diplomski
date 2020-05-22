import java.io.File;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Projects.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("src/forum19953731/input.xml");
        Projects projects = (Projects) unmarshaller.unmarshal(xml);
    }

}