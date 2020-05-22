import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;    
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;


    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();

    StringBuilder xmlStringBuilder = new StringBuilder();
    xmlStringBuilder.append("<html> <body><input id=\"942981037_3-4\" type=\"text\" size=\"35\" value=\"533\" data-valid=\"-0123456789\" class=\"validated\"/></body></html>");
    ByteArrayInputStream input = new ByteArrayInputStream(
        xmlStringBuilder.toString().getBytes("UTF-8"));
    Document doc = builder.parse(input);
    System.out.println(doc.getDocumentElement().getElementsByTagName("input").item(0).getAttributes().getNamedItem("value"));