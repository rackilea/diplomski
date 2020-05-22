private static void processNode(Node node) {
    if (node instanceof TextNode) {

      Node parent = node.parent();
      if (parent != null && (StringUtils.equalsAnyIgnoreCase(parent.nodeName(),
        "a", "iframe", "embed" , "img" , "object" , "script" , "video" , "applet"))) {
        logger.debug("parent = {} , skipped", parent.nodeName());
      }
      else {
        TextNode textNode = (TextNode) node;

        String text = textNode.text();
        text = urlPattern.matcher(text).replaceAll("<a href='$0' target='_blank'>$0</a>");

        TextNode r = new TextNode(text , null);
        node.replaceWith(r);
      }
    } else if (node instanceof Element) {
      Element ele = (Element) node;
      for (Node childNode : ele.childNodes()) {
        processNode(childNode);
      }
    }
  }