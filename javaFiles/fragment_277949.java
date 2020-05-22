String xml = ...;
try {
   // Build structures to parse the String
   DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
   // Parse the XML string into a DOM object
   Document document= builder.parse(new ByteArrayInputStream(xml.getBytes()));
   // Create an XPath query
   XPath xPath =  XPathFactory.newInstance().newXPath();
   // Query the DOM object with the query '//hello'
   NodeList nodeList = (NodeList) xPath.compile("//hello").evaluate(document, XPathConstants.NODESET);
} catch (Exception e) {
   e.printStackTrace();
}