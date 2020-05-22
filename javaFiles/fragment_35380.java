import javax.xml.xpath.*;
import javax.xml.parsers.*;

Document doc = db.parse(xmlFile);

XPath xPath =  XPathFactory.newInstance().newXPath();
NodeList nList = (NodeList)xPath.compile("/CinemaCity/genre/comedy/films")
        .evaluate(doc, XPathConstants.NODESET);

System.out.println("Information of comedy films");
...