public class Example {

    static Node root = new Node("List Persons",
    new Node("jndi",
            new Node("ejbmodule",
                new Node("context",
                    new Node("leaf",
                        new Node("name"),
                        new Node("type"),
                        new Node("year"),
                        new Node("attribute"),
                        new Node("test1", new Node("name"))
                    ),
                    new Node("name"),
                    new Node("type"),
                    new Node("year"),
                    new Node("leaf",
                        new Node("name"),
                        new Node("type"),
                        new Node("year"),
                        new Node("attribute")
                    )
                )
            )
    )
    );

    static int globalCounter = 0;

    public static void main(String[] args) {

        traverse(root, globalCounter++, -1, null);

    }

    private static String add(String tree, int global, int parent, String name) {
        return tree + ".add(" + global + ", " + parent + ", '" + name + "');";
    }

    public static void traverse(Node node, int currentId, int parentId, StringBuffer html) {
        handle_node(node, currentId, parentId, html);
        //if (node.hasChildNodes()) {
            //NodeList children = node.getChildNodes();
            for (Node kid : node.childs) {
                //Node kid = children.item(i);
                //if (kid.getNodeType() == Node.ELEMENT_NODE) {
                    traverse(kid, globalCounter++ , currentId, html);
                //}
            }
        //}
    }

    public static void handle_node(Node node, int currentId, int parentId, StringBuffer html) {
        //if (node.getNodeType() == Node.ELEMENT_NODE) {
            String value = node.value; //getNodeValue(node);

            System.out.println(add("decisionReportTree", currentId, parentId, value ));
            //if(null != value && value.trim().length() > 0) {
            //    html.append(add("decisionReportTree", currentId, parentId, node.getNodeName() + ":::" + value));
            //} else {
            //    html.append(add("decisionReportTree", currentId, parentId, node.getNodeName()));
            //}
        //}
    }
}
class Node {
    String value;
    Node[] childs;

    public Node(String value, Node... childs) {
        this.value = value;
        this.childs = childs;
    }

}