XPath xpath = XPathFactory.newInstance().newXPath();
XPathExpression expr;

String select = "//*[@slot='address']";
expr = xpath.compile(select);
NodeList result = (NodeList)expr.evaluate(input, XPathConstants.NODESET);

String normalize = "normalize-space(.)";
expr = xpath.compile(normalize);

int length = result.getLength();
for (int i = 0; i < length; i++) {
    System.out.println(expr.evaluate(result.item(i), XPathConstants.STRING));
}