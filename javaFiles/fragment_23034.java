import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws JAXBException
    {
        System.out.println( "Hello World!" );
        String filePath = ".\\p1.xml";

        File file = new File(filePath);
        JAXBContext jaxbContext = JAXBContext.newInstance(P1.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        P1 p = (P1) jaxbUnmarshaller.unmarshal(file);

        List<String> cts =  p.getCts();
        // Size of list coming right `2`
        for (String c : cts) {
              System.out.println(c);
        }
    }
}