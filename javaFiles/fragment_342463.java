private List<String> getHeaders(Document document) {
    Element root = document.getDocumentElement();
    NodeList list = root.getChildNodes();
    List<String> headers = new ArrayList<String>();

    for (int i=0; i< list.getLength(); i++) {
        if (list.item(i).getNodeType() == Node.ELEMENT_NODE) {
            Node node = list.item(i);
            addNode(node, headers);
            break;
    }
}
    return headers;
}

private void addNode(Node node, List<String> headers)
{
  NodeList nodeList = node.getChildNodes();
  if(nodeList==null||nodeList.Length==0)return;
  int children = nodeList.getLength();
  for (int k = 0; k < children; k++) {
      if (nodeList.item(k).getNodeType() == Node.ELEMENT_NODE) {
          headers.add(nodeList.item(k).getNodeName());
          addNode(nodeList.item(k), headers);
      }
  }
}