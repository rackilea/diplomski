package com.akonizo.examples;

import java.io.ByteArrayInputStream;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

public class XmlInsertExample {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String initial = "<root><param value=\"abc\"/><param value=\"bc\"/></root>";

        try {
            // Parse the initial document
            ByteArrayInputStream is = new ByteArrayInputStream(initial.getBytes());
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(is);

            // Create the new xml fragment
            Text a = doc.createTextNode("afds");
            Node p = doc.createElement("parameterDesc");
            p.appendChild(a);
            Node i = doc.createElement("insert");
            i.appendChild(p);
            Element r = doc.getDocumentElement();
            r.insertBefore(i, r.getFirstChild());
            r.normalize();

            // Format the xml for output
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            // initialize StreamResult with File object to save to file
            StreamResult result = new StreamResult(new StringWriter());
            DOMSource source = new DOMSource(doc);
            transformer.transform(source, result);

            System.out.println(result.getWriter().toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}