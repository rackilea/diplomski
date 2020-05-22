DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
DocumentBuilder builder = factory.newDocumentBuilder();
Document doc = builder.parse("yourfile.xml");
XPathFactory xPathfactory = XPathFactory.newInstance();
XPath xpath = xPathfactory.newXPath();
XPathExpression expr = xpath.compile("//entry");

Object set = expr.evaluate(doc, XPathConstants.NODESET);

NodeList list = (NodeList) set;
int count = list.getLength();
for (int i = 0; i < count; i++) {
    Node node = list.item(i);
    // Handle the entry node here
}