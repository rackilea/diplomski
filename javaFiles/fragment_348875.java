XPath xpath = XPathFactory.newInstance().newXPath();  
String expression = "//sura";  
InputSource inputSource = new InputSource("filename.xml");  
NodeList nodes = (NodeList) xpath.evaluate(expression, inputSource, XPathConstants.NODESET);  

for(int i=0; i<nodes.getLength(); i++) {  
    Node sura = nodes.item(i);  
    NamedNodeMap attributes = sura.getAttributes();  
    attributes.getNamedItem("name").getNodeValue()  
}