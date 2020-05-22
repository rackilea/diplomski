String xml = "<resp><status>good</status><msg>hi</msg></resp>";

InputSource source = new InputSource(new StringReader(xml));

DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
DocumentBuilder db = dbf.newDocumentBuilder();
Document document = db.parse(source);

XPathFactory xpathFactory = XPathFactory.newInstance();
XPath xpath = xpathFactory.newXPath();

String msg = xpath.evaluate("/resp/msg", document);
String status = xpath.evaluate("/resp/status", document);

System.out.println("msg=" + msg + ";" + "status=" + status);