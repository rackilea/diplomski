Document newXmlDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
  Element root = newXmlDocument.createElement("fileVersionListWrapper");
  for (int i = 0; i < nl.getLength(); i++)
  {
    Node node = nl.item(i);
    Node copyNode = newXmlDocument.importNode(node, true);
    root.appendChild(copyNode);
  }
  newXmlDocument.appendChild(root);