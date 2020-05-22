import java.io.File;
import javax.xml.bind.*;
import org.w3c.dom.Element;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Root.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("src/forum18906595/input.xml");
        Root root = (Root) unmarshaller.unmarshal(xml);

        Element element = (Element) root.getContent();
        System.out.println(element.getNodeName());
    }

}