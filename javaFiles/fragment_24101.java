import java.io.File;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class ObjectToXMLWriter {
    public static <Type> boolean writeToFileWithXmlTransformer(Type instance
            ,String fullFileNamePath) throws FileNotFoundException {
        boolean isSaved = false;
        JAXBContext jaxBContent = null;
        Marshaller marshaller = null;
        StringWriter stringWriter = new StringWriter();

        try {
            jaxBContent = JAXBContext.newInstance(instance.getClass());
            marshaller = jaxBContent.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(instance, stringWriter);

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

            transformer.transform(new StreamSource(new StringReader(stringWriter.toString()))
                    ,new StreamResult(new File(fullFileNamePath)));

           isSaved = true; 
        } catch(JAXBException jaxBException) {
            System.out.println("JAXBException happened!");
            jaxBException.printStackTrace();
        } catch(Exception exception) {
            System.out.println("Exception happened!");
            exception.printStackTrace();
        }

        return isSaved;
    }
}