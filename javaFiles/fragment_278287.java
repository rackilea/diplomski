package net.davymeers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XpathTest {
    private static String XMLSTRING = "<data>"
            + "<tobject.subject tobject.subject.refnum=\"01016000\" />\r\n"
            + "\r\n"
            + "<tobject.subject tobject.subject.refnum=\"10004000\" />"
            + "</data>";

    /**
     * @param args
     */
    public static void main(final String[] args) {

        final Document doc = createDocument();
        final XPath xpath = createXpath();

        final NodeList nodes = findElements(
                "//tobject.subject/@tobject.subject.refnum", doc, xpath);
        final Collection<String> results = convertToCollection(nodes);

        for (final String result : results) {
            System.out.println(result);
        }
    }

    private static Document createDocument() {
        Document doc = null;
        try {
            final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
                    .newInstance();
            documentBuilderFactory.setNamespaceAware(true); // never forget
                                                            // this!
            final DocumentBuilder builder = documentBuilderFactory
                    .newDocumentBuilder();
            doc = builder.parse(new ByteArrayInputStream(XMLSTRING
                    .getBytes("ISO-8859-1")));
        } catch (final UnsupportedEncodingException exception) {
            // TODO handle exception
        } catch (final SAXException exception) {
            // TODO handle exception
        } catch (final IOException exception) {
            // TODO handle exception
        } catch (final ParserConfigurationException exception) {
            // TODO handle exception
        }
        return doc;
    }

    private static XPath createXpath() {
        final XPathFactory xpathFactory = XPathFactory.newInstance();
        final XPath xpath = xpathFactory.newXPath();
        return xpath;
    }

    private static NodeList findElements(final String xpathExpression,
            final Document doc, final XPath xpath) {
        NodeList nodes = null;
        if (doc != null) {
            try {
                final XPathExpression expr = xpath.compile(xpathExpression);
                final Object result = expr
                        .evaluate(doc, XPathConstants.NODESET);
                nodes = (NodeList) result;
            } catch (final XPathExpressionException exception) {
                // TODO handle exception
            }
        }
        return nodes;
    }

    private static Collection<String> convertToCollection(final NodeList nodes) {
        final Collection<String> result = new ArrayList<String>();
        if (nodes != null) {
            for (int i = 0; i < nodes.getLength(); i++) {
                result.add(nodes.item(i).getNodeValue());
            }
        }
        return result;
    }

}