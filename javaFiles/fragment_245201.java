import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.jdom2.Document;
import org.jdom2.input.DOMBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;


public class DOMvsJDOM {

    private static org.w3c.dom.Document buildDOM(String xml) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        dbf.setValidating(false);
        dbf.setExpandEntityReferences(false);
        DocumentBuilder db = dbf.newDocumentBuilder();
        StringReader sr = new StringReader(xml);
        InputSource is = new InputSource(sr);
        return db.parse(is);
    }

    public static void printDocument(org.w3c.dom.Document doc, OutputStream out) throws Exception {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

        transformer.transform(new DOMSource(doc), 
             new StreamResult(new OutputStreamWriter(out, "UTF-8")));
    }

    private static void parseUsingJDOM(org.w3c.dom.Document doc) throws Exception {
//      Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("testxml.xml"), "UTF8"));
      DOMBuilder builder = new DOMBuilder();
      Document jdoc = builder.build(doc);
      XMLOutputter fmt = new XMLOutputter();
      fmt.setFormat(Format.getPrettyFormat());
      fmt.output(jdoc, System.out);
    }

    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        org.w3c.dom.Document doc = dbFactory.newDocumentBuilder().newDocument();
        doc.setXmlVersion("1.0");

        Element root = doc.createElement("Document");

        root.setAttribute("xmlns", "urn:iso:foo");
        root.setAttribute("xsi:schemaLocation", "urn:iso:foo bar.xsd");
        root.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
        doc.appendChild(root);

        printDocument(doc, System.out);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        printDocument(doc, baos);

        System.out.println("JDOM Using captured");
        parseUsingJDOM(doc);

        String xml = new String(baos.toByteArray());
        doc = buildDOM(xml);

        System.out.println("JDOM Using parsed");
        parseUsingJDOM(doc);

    }
}