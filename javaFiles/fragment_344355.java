package forum11644994;

import java.io.StringReader;
import java.util.Iterator;

import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.*;
import javax.xml.xpath.*;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class Demo {

    public static void main(String[] args) throws Exception {
        String xml = "<soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://services.web.post.list.com\"><soapenv:Header><authInfo xsi:type=\"soap:authentication\" xmlns:soap=\"http://list.com/services/SoapRequestProcessor\"><!--You may enter the following 2 items in any order--><username xsi:type=\"xsd:string\">dfasf@google.com</username><password xsi:type=\"xsd:string\">PfasdfRem91</password></authInfo></soapenv:Header></soapenv:Envelope>";
        System.out.println(xml);
        DocumentBuilderFactory domFactory = DocumentBuilderFactory
                .newInstance();
        domFactory.setNamespaceAware(true);
        DocumentBuilder builder = domFactory.newDocumentBuilder();
        Document doc = builder.parse(new InputSource(new StringReader(xml)));
        XPath xpath = XPathFactory.newInstance().newXPath();
        xpath.setNamespaceContext(new NamespaceContext() {

            @Override
            public Iterator getPrefixes(String arg0) {
                return null;
            }

            @Override
            public String getPrefix(String arg0) {
                return null;
            }

            @Override
            public String getNamespaceURI(String arg0) {
                if("soapenv".equals(arg0)) {
                    return "http://schemas.xmlsoap.org/soap/envelope/";
                }
                return null;
            }
        });
        // XPath Query for showing all nodes value

        try {
            XPathExpression expr = xpath
                    .compile("/soapenv:Envelope/soapenv:Header/authInfo/password");
            Object result = expr.evaluate(doc, XPathConstants.NODESET);
            NodeList nodes = (NodeList) result;
            System.out.println("Got " + nodes.getLength() + " nodes");
            // System.out.println(nodes.item(0).getNodeValue());
        } catch (Exception E) {
            System.out.println(E);
        }

    }
}