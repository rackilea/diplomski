import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
Document document = builder.parse(getClass().getResourceAsStream("test.xml"));

XPath xpath = XPathFactory.newInstance().newXPath();

NodeList nodeList = (NodeList) xpath.evaluate("//branch//attribute", document, XPathConstants.NODESET);

for (int i = 0, len = nodeList.getLength(); i < len; i++) {
    final Element attributeNode = (Element) nodeList.item(i);

    String value = attributeNode.getAttribute("name");

    if (value.equals("name1")) {
        attributeNode.setAttribute("value", "this is the question for the yes item ");
    }
    else if (value.equals("name2")) {
        attributeNode.setAttribute("value", "this is the question for the no item ");
    }
}