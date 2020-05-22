import java.io.FileReader;
import javax.xml.stream.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader sr = factory.createXMLStreamReader(new FileReader("test.xml"));
        System.out.println(sr.getClass());

        while (sr.hasNext()) {
            int eventType = sr.next();

            if (eventType == XMLStreamReader.START_DOCUMENT) {
                continue;
            } else if (eventType == XMLStreamReader.END_ELEMENT) {
                System.out.println("End Element:    " + sr.getLocalName());
            } else if (eventType == XMLStreamReader.START_ELEMENT) {
                System.out.println("Start Element:  " + sr.getLocalName());
            }
        }
    }

}