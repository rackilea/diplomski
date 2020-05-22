DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
factory.setNamespaceAware(true); // never forget this!
DocumentBuilder builder = factory.newDocumentBuilder();
Document doc = builder.parse("a.xml");
XPathFactory xPathFactory = XPathFactory.newInstance();
XPath xpath = xPathFactory.newXPath();
XPathExpression expr = xpath.compile("//dataObject[@name='pcsp']/map/entry/string[text()='shipment_id']/../string[2]/text()");
NodeList result = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
System.out.println(result.item(0).getNodeValue());