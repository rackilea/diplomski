DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

try {

    DocumentBuilder builder = dbf.newDocumentBuilder();
    // input stream of any kind, can be local or from URL
    Document doc = builder.parse(new InputSource(inputStream));
    doc.getDocumentElement().normalize();

    // rowNodeName in my case is "item" so you can change this to anything suitable
    nodeList = doc.getElementsByTagName(rowNodeName);

} catch (ParserConfigurationException | IOException | SAXException e) {

    e.printStackTrace();

}