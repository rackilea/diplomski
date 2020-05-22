public class ForTestApplication {

  public static void main(String[] args) {

    NodeArray jsonContainer = new NodeArray(
        new Node("nodes",  new NodeArray(
            new Node("12131231231231241", new NodeArray(
                new Node("gToken",
                    new Node("token", "AABBCCDDEEFF99001122334455667788")),
                new Node("objects", new NodeArray(
                    new Node("WATER_CONTROL_1", "0"),
                    new Node("WATER_CONTROL_2", "1")
                )))),
            new Node("7682642342432423", new NodeArray(
                new Node("userAuthentication", new NodeArray(
                    new Node("userEmail","user@mail.com"),
                    new Node("userPassword","userPassword")
                )),
                new Node("objects", new NodeArray(
                    new Node("WATER_CONTROL_1", "0"),
                    new Node("WATER_CONTROL_2", "1")
                ))
            ))
        )));

    System.out.println(jsonContainer.toJSONString());
  }

}

class NodeArray {
  private static final String NODE_TEMPLATE = "\"%s\":%s";
  private static final Gson gson = new Gson();

  private List<Node> nodes = new ArrayList<>();

  public NodeArray(Node... nodes){
    addNode(nodes);
  }

  public void addNode(Node... node){
    nodes.addAll(Arrays.asList(node));
  }

  public String toJSONString() {

    return nodes.stream()
        .map(node -> String.format(NODE_TEMPLATE, node.getNodeName(), getNodeBodyAsJSON(node)))
        .collect(Collectors.joining(",", "{", "}"));
  }

  private String getNodeBodyAsJSON(Node node) {
    if (node.getNodeBody() instanceof NodeArray) {
      return ((NodeArray) node.getNodeBody()).toJSONString();
    }
    return gson.toJson(node.getNodeBody());
  }

}

class Node {
  private final String nodeName;
  private final Object nodeBody;

  public Node(String nodeName, Object nodeBody) {
    this.nodeName = nodeName;
    this.nodeBody = nodeBody;
  }

  public String getNodeName() {
    return nodeName;
  }

  public Object getNodeBody() {
    return nodeBody;
  }
}