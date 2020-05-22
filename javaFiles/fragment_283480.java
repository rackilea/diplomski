package forum11344031;

import java.io.StringReader;
import javax.xml.bind.*;
import javax.xml.stream.*;

public class Demo {

    private static final XMLInputFactory XIF = XMLInputFactory.newFactory();

    public static Object toXMLObject(String XMLString, Class xmlClass)
            throws Exception {
        Object o;
        StringReader strReader = null;
        try {
            JAXBContext context = JAXBContexts.getJAXBContext(xmlClass); //Cached JAXBContext
            Unmarshaller unmarshaller = context.createUnmarshaller();

            strReader = new StringReader(XMLString);
            XMLStreamReader xmlStreamReader = XIF.createXMLStreamReader(strReader);
            o = unmarshaller.unmarshal(xmlStreamReader);
            xmlStreamReader.close();
        } catch(Exception e){
            throw e;
        } finally {
            if(strReader != null){
                strReader.close();
            }
        }
        return o;
    }

}