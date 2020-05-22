public static Element getPreviousSiblingElement(Node node) {
      Node prevSibling = node.getPreviousSibling();
      while (prevSibling != null) {
          if (prevSibling.getNodeType() == Node.ELEMENT_NODE) {
              return (Element) prevSibling;
          }
          prevSibling = prevSibling.getPreviousSibling();
      }

      return null;  
  }