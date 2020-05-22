public static void main(String[] args) throws Exception {
    Document doc = parseDocument("properties.xml");
    List<Element> valueElements = getValueElements(doc);  // or getValueElementsUsingXpath(doc)

    int nodeNumber = 0;
    for (Element element : valueElements) {
      nodeNumber++;
      System.out.println("Node " + nodeNumber + ": " + formatValueElement(element));
    }
  }

  private static String formatValueElement(Element element) {
    StringBuffer result = new StringBuffer();

    boolean first = true;
    NodeList children = ((Element) element).getChildNodes();
    for (int i = 0, len = children.getLength(); i < len; i++) {
      Node child = children.item(i);

      String childText = null;
      switch (child.getNodeType()) {
      case Node.CDATA_SECTION_NODE:
      case Node.TEXT_NODE:
        childText = child.getTextContent().trim();
      }

      if (childText == null || childText.isEmpty()) {
        continue;
      }

      if (first)
        first = false;
      else
        result.append(" ");

      result.append(childText);
    }

    return result.toString();
  }