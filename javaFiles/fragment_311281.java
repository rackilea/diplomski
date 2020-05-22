import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

    public class Main {
      public static void main(String[] argv) throws Exception{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);

        factory.setExpandEntityReferences(false);

        Document doc = factory.newDocumentBuilder().parse(new File("filename"));

        Element root = null;

        NodeList list = doc.getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
          if (list.item(i) instanceof Element) {
            root = (Element) list.item(i);
            break;
          }
        }
        root = doc.getDocumentElement();
      }
    }