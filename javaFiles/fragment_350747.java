public class TestXPath {

    public static void main(String[] args) {
        String xml =
                        "<root>\n"
                        + "    <thing>\n"
                        + "        <name>Thing1</name>\n"
                        + "        <property>\n"
                        + "            <name>Property1</name>\n"
                        + "        </property>\n"
                        + "        <property>\n"
                        + "            <name>Property2</name>\n"
                        + "        </property>\n"
                        + "        <property>\n"
                        + "            <name>Property3</name>\n"
                        + "        </property>\n"
                        + "        <property>\n"
                        + "            <name>Property4</name>\n"
                        + "        </property>\n"
                        + "        <property>\n"
                        + "            <name>Property5</name>\n"
                        + "        </property>\n"
                        + "    </thing>/n"
                        + "    <NoAThin>\n"
                        + "        <name>Thing2</name>\n"
                        + "        <property>\n"
                        + "            <name>Property1</name>\n"
                        + "        </property>\n"
                        + "        <property>\n"
                        + "            <name>Property2</name>\n"
                        + "        </property>\n"
                        + "        <property>\n"
                        + "            <name>Property3</name>\n"
                        + "        </property>\n"
                        + "        <property>\n"
                        + "            <name>Property4</name>\n"
                        + "        </property>\n"
                        + "        <property>\n"
                        + "            <name>Property5</name>\n"
                        + "        </property>\n"
                        + "    </NoAThin>/n"
                        + "</root>";

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            ByteArrayInputStream bais = new ByteArrayInputStream(xml.getBytes());
            Document dom = db.parse(bais);
            XPath xpath = XPathFactory.newInstance().newXPath();

            // Find the "thing" node...
            XPathExpression thingExpr = xpath.compile("/root/thing");
            NodeList things = (NodeList) thingExpr.evaluate(dom, XPathConstants.NODESET);

            System.out.println("Found " + things.getLength() + " thing nodes...");

            // Find the property nodes of thing
            XPathExpression expr = xpath.compile("property");
            NodeList nodes = (NodeList) expr.evaluate(things.item(0), XPathConstants.NODESET);

            System.out.println("Found " + nodes.getLength() + " thing/property nodes...");

            // Find all the property "name" nodes under thing
            expr = xpath.compile("property/name");
            nodes = (NodeList) expr.evaluate(things.item(0), XPathConstants.NODESET);

            System.out.println("Found " + nodes.getLength() + " name nodes...");
            System.out.println("Property value = " + nodes.item(0).getTextContent());

            // Find all nodes that have property nodes
            XPathExpression exprAll = xpath.compile("/root/*/property");
            NodeList nodesAll = (NodeList) exprAll.evaluate(dom, XPathConstants.NODESET);
            System.out.println("Found " + nodesAll.getLength() + " property nodes...");

        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }
}