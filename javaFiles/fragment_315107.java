import java.io.InputStream;
import java.net.URL;
import javax.xml.bind.*;
import javax.xml.transform.stream.StreamSource;
import org.w3._2005.atom.FeedType;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance("org.w3._2005.atom");

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        URL url = new URL("http://bdoughan.blogspot.com/atom.xml");
        InputStream xml = url.openStream();
        JAXBElement<feedtype> feed = unmarshaller.unmarshal(new StreamSource(xml), FeedType.class);
        xml.close();

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(feed, System.out);
    }

}