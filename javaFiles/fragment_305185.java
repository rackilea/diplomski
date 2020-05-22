import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class A {

    public static void main(String[] args) throws Exception {
        XPathFactory xPathfactory = XPathFactory.newInstance();
        XPath xpath = xPathfactory.newXPath();

        String xml1 = "<xml><car_dealer><car_id>2</car_id></car_dealer><car><car_id>12345678</car_id></car></xml>";
        String xml2 = "<xml><car_dealer><car_id>2</car_id></car_dealer><car><car_type id_1=\"2\" id_2=\"32\">55555</car_type></car></xml>";

        Document doc1 = stringToDom(xml1);
        Document doc2 = stringToDom(xml2);

        XPathExpression expr1 = xpath.compile("//car/car_id/text()");
        String carId = (String) expr1.evaluate(doc1, XPathConstants.STRING);

        XPathExpression expr2 = xpath.compile("//car/car_type/text()");
        String carType = (String) expr2.evaluate(doc2, XPathConstants.STRING);

        System.out.println("***");
        System.out.println("carId: " + carId);
        System.out.println("carType: " + carType);
        System.out.println("***");

        /* prints 
           ***
           carId: 12345678
           carType: 55555
           ***
        */
    }

    public static Document stringToDom(String xmlSource) throws SAXException,
            ParserConfigurationException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(new InputSource(new StringReader(xmlSource)));
    }
}