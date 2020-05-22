import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class JaxbApp {

    public static void main(String[] args) throws Exception {
        File xmlFile = new File("./resource/test.xml").getAbsoluteFile();

        JAXBContext jaxbContext = JAXBContext.newInstance(Root.class);

        Object unmarshal = jaxbContext.createUnmarshaller().unmarshal(new FileReader(xmlFile));
        System.out.println(unmarshal);
    }
}