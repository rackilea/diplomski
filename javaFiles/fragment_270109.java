private static List<Element> getValueElements(Document document) {
    List<Element> result = new ArrayList<Element>();
    NodeList propertyElements = document.getElementsByTagName("property");
    for (int i = 0, ilen = propertyElements.getLength(); i < ilen; i++) {
      Node propertyNode = propertyElements.item(i);
      if (!(propertyNode instanceof Element))
        continue;

      NodeList children = ((Element) propertyNode).getChildNodes();
      for (int j = 0, jlen = children.getLength(); j < jlen; j++) {
        Node child = children.item(j);
        if (!(child instanceof Element) || !"value".equals(child.getNodeName()))
          continue;

        result.add((Element) child);
      }
    }
    return result;
  }