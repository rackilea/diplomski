package test;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;



public class Test {

  public static void main(String[] argv) throws XPathExpressionException, SAXException, IOException, ParserConfigurationException {
    XPathFactory fac = XPathFactory.newInstance();
    XPathExpression idDivExpr = fac.newXPath().compile("//div[@class='list']");
    XPathExpression timeExpr = fac.newXPath().compile("div[@class='time']");
    XPathExpression subjExpr = fac.newXPath().compile("div[@class='subject']");
    InputStream in = Test.class.getResourceAsStream("foo.html");
    Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(in);
    NodeList nl = (NodeList) idDivExpr.evaluate(doc, XPathConstants.NODESET);
    for (int i = 0; i < nl.getLength(); i++) {
      Element elt = (Element) nl.item(i);
      System.out.printf("%s|%s|%s\n",
          elt.getAttribute("id"),
          timeExpr.evaluate(elt),
          subjExpr.evaluate(elt));
    }
  }
}