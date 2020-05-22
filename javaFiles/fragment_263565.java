import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class TestFile {
    public static final String xmlFileFolder = "C:\\Rahul\\test";
    private static final String initialValue = "450-000-1212";

    public static void main(String argv[]) {
        int baseValue = Integer.parseInt(getValueAfterLastDash(initialValue));
        System.out.println("startValue " + baseValue);
        File folder = new File(xmlFileFolder);
        for (File file : folder.listFiles()) {
            try {
                DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

                Document document = documentBuilder.parse(file);

                Node employee = document.getElementsByTagName("employee").item(0);
                NamedNodeMap attribute = employee.getAttributes();
                Node nodeAttr = attribute.getNamedItem("number");
                System.out.println(getValueBeforeLastDash(initialValue) + baseValue);
                nodeAttr.setTextContent(getValueBeforeLastDash(initialValue) + baseValue);

                TransformerFactory transformerFactory = TransformerFactory.newInstance();

                Transformer transformer = transformerFactory.newTransformer();
                DOMSource domSource = new DOMSource(document);

                StreamResult streamResult = new StreamResult(file);
                transformer.transform(domSource, streamResult);
                baseValue++;
            } catch (Exception ignored) {
            }
        }
    }

    private static String getValueAfterLastDash(String initialValue) {
        return initialValue.substring(initialValue.lastIndexOf('-') + 1, initialValue.length());
    }

    private static String getValueBeforeLastDash(String initialValue) {
        return initialValue.substring(0, initialValue.lastIndexOf('-') + 1);
    }
}