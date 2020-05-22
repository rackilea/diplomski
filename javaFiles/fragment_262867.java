import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

try {
    dbf.setFeature("http://xml.org/sax/features/validation", false);
} catch (ParserConfigurationException e) {
    System.err.println("could not set parser feature");
}