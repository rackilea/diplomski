import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;   

XPath xpath = XPathFactory.newInstance().newXPath();
Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("input.xml");
String phone = xpath.evaluate("//user[last()]/account/@phone", doc);
System.out.println(phone);