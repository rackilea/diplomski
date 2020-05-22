DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
InputSource src = new InputSource();
src.setCharacterStream(new StringReader(xml));

Document doc = builder.parse(src);
String age = doc.getElementsByTagName("age").item(0).getTextContent();
String name = doc.getElementsByTagName("name").item(0).getTextContent();