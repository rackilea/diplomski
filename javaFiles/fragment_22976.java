DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
Document doc;
doc = f.newDocumentBuilder().parse(<xml>);
NodeList langs = doc.getElementsByTagName("languages");
ArrayList<String> data = new ArrayList<String>();
String lang = null;
for (int i = 0; i < langs.getLength(); i++) {
Node n = langs.item(i);
if (n.getFirstChild().getNodeType() == Node.TEXT_NODE) {
   lang = n.getFirstChild().getNodeValue();
   data.add(lang);
}