import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

XPath xPath =  XPathFactory.newInstance().newXPath();
String expression = "/city/jbeil/restaurant/name";
//read a string value
String thename= xPath.compile(expression).evaluate(xmlDocument);