import java.io.File;
import javax.xml.XMLConstants;
import javax.xml.parsers.*;
import javax.xml.validation.*;

import org.w3c.dom.Document;

public class Demo {

    public static void main(String[] args) throws Exception {
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema s = sf.newSchema(new File("src/forum16231687/schema.xsd"));

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setSchema(s);
        dbf.setIgnoringElementContentWhitespace(true);

        DocumentBuilder db = dbf.newDocumentBuilder();
        Document d = db.parse(new File("src/forum16231687/input.xml"));
        System.out.println(d.getDocumentElement().getChildNodes().getLength());
    }

}