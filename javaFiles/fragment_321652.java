public class UtilsXML {

    private static Document doc;

    // Root "ORDER"
    public static Element addRoot(String rootName) {
        Element root = doc.createElement(rootName);
        doc.appendChild(root);
        return root;
    }

    // Elements inside ROOT like INFO, OTHERS
    public static Element addElement(String rootName, Element root) {
        Element e = doc.createElement(rootName);
        root.appendChild(e);
        return e;
    }

    // Elements inside other elements INFO -> Id, Value
    public static void addNode(Element e, String tagName, String content) {
        Element employ = doc.createElement(tagName);
        employ.appendChild(doc.createTextNode(content));
        e.appendChild(employ);
    }

    // Document
    public static void makeDoc() throws ParserConfigurationException {
        DocumentBuilderFactory dF = DocumentBuilderFactory.newInstance();
        DocumentBuilder docB = dF.newDocumentBuilder();
        doc = docB.newDocument();       
    }

    // Save the xml file
    public static void makeFile(String filePath) throws TransformerException {
        TransformerFactory tF = TransformerFactory.newInstance();
        Transformer t = tF.newTransformer();
        DOMSource source = new DOMSource(doc);
        File xml = new File(filePath);
        StreamResult r = new StreamResult(xml);
        t.transform(source, r);
    }
}