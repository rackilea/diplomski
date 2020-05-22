public class NS {
  private static void print(Node node) {
    Queue<Node> nodes = new LinkedList<Node>();
    nodes.add(node);
    while (!nodes.isEmpty()) {
      node = nodes.poll();
      NodeList list = node.getChildNodes();
      for (int i = 0; i < list.getLength(); i++) {
        nodes.add(list.item(i));
      }
      System.out.format("%s %s %s%n", node.getPrefix(), node.getLocalName(),
          node.getNamespaceURI());
    }
  }

  public static void main(String[] args) throws Exception {
    String xml = "<a xmlns=\"http://domain/a\">"
        + "<pre:b xmlns:pre=\"http://domain/b\">" + "<c/>" + "<d xmlns=\"\">"
        + "<e/>" + "</d>" + "</pre:b>" + "</a>";

    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    dbf.setNamespaceAware(true);
    Document doc = dbf.newDocumentBuilder().parse(
        new InputSource(new StringReader(xml)));
    print(doc.getDocumentElement());
  }
}