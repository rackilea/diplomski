// ...
import javax.xml.transform.dom.DOMSource; 
import javax.xml.transform.stream.StreamSource; 
import javax.xml.transform.stream.StreamResult; 
// ... 

public class Stylizer {
    // ...
    public static void main (String argv[]) {
        // ...
        try {
            File stylesheet = new File(argv[0]);
            File datafile = new File(argv[1]);

            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.parse(datafile);
            // ...
            StreamSource stylesource = new StreamSource(stylesheet); 
            Transformer transformer = Factory.newTransformer(stylesource);
        }
    }
}