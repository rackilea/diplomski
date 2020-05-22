public class XPathTest {

    public static void main(String[] args) throws XPathExpressionException, SAXException, IOException, ParserConfigurationException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File("file.xml"));
        XPath xxPath = XPathFactory.newInstance().newXPath();
        String expression = "/Envelope/Body/response/result";
        javax.xml.xpath.XPathExpression cc = xxPath.compile(expression);
        String result  = cc.evaluate(doc);
        System.out.println("Result:: " + result);
    }
}