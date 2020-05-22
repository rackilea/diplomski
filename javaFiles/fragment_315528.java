import java.io.*;

import org.jdom2.*;
import org.jdom2.input.*;
import org.jdom2.output.*;

public class Test {
    public static void main(String args[]) throws IOException, JDOMException {
        File input = new File("input.xml"); 
        Document document = new SAXBuilder().build(input);
        Element element = new Element("event");
        element.setAttribute("title", "foo");
        // etc...
        document.getRootElement().addContent(element);

        // Java 7 try-with-resources statement; use a try/finally
        // block to close the output stream if you're not using Java 7
        try(OutputStream out = new FileOutputStream("output.xml")) {
            new XMLOutputter().output(document, out);
        }
    }
}