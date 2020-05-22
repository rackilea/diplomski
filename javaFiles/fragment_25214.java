public class MyNodeList implements NodeList {
    Node root = null;
    int length = 0;
    public MyNodeList() {}

    public void addNode(Node node) {
        if(root == null)
            root = node;
        else
            root.addChild(node);
        length++;
    }

    public Node item(int index) {
        if(index < 1) return root;
        Node node = root;
        while(index > 0) {
           node = node.getFirstChild();
           if(node == null) return node;
           index--;
        }
        return node;
    }

    public int getLength() {
        return length;
    }
}