import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.SAXException;


Reader xml = new StringReader("<xml />");
             Document document  = null;
             SAXReader reader = new SAXReader();
              document = reader.read(xml);

              List <Element> elements = getXmlElements(document,"//Final-Results");
for(int index = 0; index < elements.size();index ++){
                    Element element = elements.get(index);
System.out.println("The required xml "+element.asXML())
}