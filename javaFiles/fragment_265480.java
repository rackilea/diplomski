DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
dbf.setNamespaceAware(true); //This is really important, without it that XPath does not work
DocumentBuilder db = dbf.newDocumentBuilder();
Document document = db.parse(inputSource); //inputSource, inputStream or file which contains your XML.
XPath xpath = XPathFactory.newInstance().newXPath();
String nameSpace = xpath.evaluate("/*/namespace::*[name()='']", document);
String soapNameSpace = xpath.evaluate("/*/namespace::*[name()='soap']", document);