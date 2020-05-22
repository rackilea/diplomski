InputSource src = new InputSource();
src.setCharacterStream(new StringReader(response.toString()));

DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
Document doc = builder.parse(src);

XPathFactory xPathfactory = XPathFactory.newInstance();
XPath xpath = xPathfactory.newXPath();
XPathExpression expr = xpath.compile("//Field[@Name='test-id']/Value");

System.out.println(expr.evaluate(doc, XPathConstants.STRING));