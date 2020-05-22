public String[] listOperations(String filename) throws FileNotFoundException, SAXException, IOException, ParserConfigurationException {
  Document d = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new FileInputStream(filename));
  NodeList elements = d.getElementsByTagName("operation");
  ArrayList<String> operations = new ArrayList<String>();
  for (int i = 0; i < elements.getLength(); i++) {
    operations.add(elements.item(i).getAttributes().getNamedItem("name").getNodeValue());
  }
  return operations.toArray(new String[operations.size()]);
}