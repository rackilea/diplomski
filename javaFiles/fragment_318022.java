import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.UnmarshallerHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

public class Demo {

    public static void main(String[] args) throws Exception {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser();
        XMLReader xr = sp.getXMLReader();

        JAXBContext jc = JAXBContext.newInstance(MyResponse.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        UnmarshallerHandler unmarshallerHandler = unmarshaller.getUnmarshallerHandler();
        xr.setContentHandler(unmarshallerHandler);

        String data = ...;
        StringReader reader = new StringReader(data);
        InputSource xmlSource = new InputSource(reader);
        xr.parse(xmlSource);

        MyResponse myResponse = (MyResponse) unmarshallerHandler.getResult();
     }

}