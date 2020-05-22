import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.OutputKeys;

import java.io.*;
import java.net.URISyntaxException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
public class XmlSplit {
    public static void main(String[] args) throws IOException, URISyntaxException,
                                                  SAXException, ParserConfigurationException,
                                                  TransformerException {

        // Load XML Source
        String inputXML = "/path/to/XMLSource.xml";

        // Declare XML Values Array
        String[] xmlVals = {"abc", "xyz"};

        // Iterate through Values running dynamic, embedded XSLT
        for (String s: xmlVals) {
            String outputXML = "/path/to/output_" + s + ".xml";

            String xslStr = String.join("\n",
                "<xsl:transform xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" version=\"1.0\">",
                "<xsl:output version=\"1.0\" encoding=\"UTF-8\" indent=\"yes\" />",
                "<xsl:strip-space elements=\"*\"/>",
                "<xsl:template match=\"@*|node()\">",
                "<xsl:copy>",
                "<xsl:apply-templates select=\"@*|node()\"/>",
                "</xsl:copy>",
                "</xsl:template>",
                "<xsl:template match=\"child[not(@value='"+ s +"')]\"/>",
                "</xsl:transform>");

            Source xslt = new StreamSource(new StringReader(xslStr));            
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();            
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse (new File(inputXML));

            // XSLT Transformation  with pretty print
            TransformerFactory prettyPrint = TransformerFactory.newInstance();
            Transformer transformer = prettyPrint.newTransformer(xslt);

            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");                        

            // Output Result to File
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(outputXML));        
            transformer.transform(source, result);
        }

    }
}