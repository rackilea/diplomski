package org.foo.bar.foobar;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nu.xom.Nodes;

import org.cyberneko.html.parsers.DOMParser;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;
import org.dom4j.XPath;
import org.dom4j.io.DOMReader;
import org.dom4j.io.XMLWriter;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class App 
{
    public static void main( String[] args ) throws SAXException, IOException
    {

        DOMParser parser = new DOMParser();

        parser.parse(new InputSource("file:///Z:/homepage.htm"));
        org.w3c.dom.Document doc = parser.getDocument();

        DOMReader reader = new DOMReader();
        Document document = reader.read(doc);

        XMLWriter xmlWriter = new XMLWriter(System.out);
        xmlWriter.write(document);

        @SuppressWarnings("unchecked")

        List<Node> nodes = document.selectNodes("//*[local-name()='HEAD']/*[local-name()='LINK']");
        System.out.println("Number of Nodes: " +nodes.size());

        Map<String, String> namespaceUris = new HashMap<String, String>();  
        namespaceUris.put("foobar", "http://www.w3.org/1999/xhtml");  

        XPath xPath = DocumentHelper.createXPath("//foobar:HEAD/foobar:LINK");  
        xPath.setNamespaceURIs(namespaceUris);  

        @SuppressWarnings("unchecked")
        List<Nodes> selectNodes = xPath.selectNodes(document);
        System.out.println("Number of nodes: " +selectNodes.size());

    }
}