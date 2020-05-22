final InputStream is = new FileInputStream('your.xml');

final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
final DocumentBuilder builder = factory.newDocumentBuilder();
final Document doc = builder.parse(is);
final XPathFactory xPathfactory = XPathFactory.newInstance();
final XPath xpath = xPathfactory.newXPath();
final XPathExpression expr = xpath.compile("/city/stock/name[text()='Sony']");