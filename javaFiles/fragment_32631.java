public class Node {

    private String name;
    private int count;
    private List<Node> children;

    public Node() {
        this(null, 0);
    }

    public Node(String name, int count) {
        this.name = name; 
        this.count = count;
        this.children = new ArrayList<Node>();
    }


    public void addChild(Node n) {
        for (Node nn : children) {
            if (nn.name.equals(n.name)) {
                return;
            }
        }
        this.children.add(n);
    }

    public void addCost(int i) {
        this.count += i;
    }
}