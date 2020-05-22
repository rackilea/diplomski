// split up URL parameters into attribute value pairs
String[] pairs = s.split("&");

// expect the first attribute/value pair to contain the data
// and decode the URL escape sequences
String resData = URLDecoder.decode(pairs[0], "utf-8");

int equalIndex = resData.indexOf("=");
if (equalIndex >= 0) {
    // the value is right of the '=' sign
    String xmlString = resData.substring(equalIndex + 1);

    // prepare XML parser
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder parser = dbf.newDocumentBuilder();

    InputSource is = new InputSource(new StringReader(xmlString));
    Document doc = parser.parse(is);

    // prepare XPath expression to extract request token
    XPath xpath = XPathFactory.newInstance().newXPath();
    XPathExpression xp = xpath.compile("//request_token/text()");

    String requestToken = xp.evaluate(doc);
}