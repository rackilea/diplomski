public class Tree {

    private final Node root = new Node(null, null);

    public boolean isEmpty() {
        return root.children.isEmpty();
    }

    public void add(String path) {
        Node parent = root;

        for (String data : path.split("/")) {
            Node node = parent.getChild(data);

            if (node == null)
                parent.children.add(node = new Node(data, parent));

            parent = node;
        }
    }

    public Node get(String path) {
        Node parent = root;

        for (String data : path.split("/")) {
            Node node = parent.getChild(data);

            if (node == null)
                return null;

            parent = node;
        }

        return parent;
    }

    public static final class Node {

        private final String data;
        private final Node parent;
        private final List<Node> children = new LinkedList<>();

        public Node(String data, Node parent) {
            this.data = data;
            this.parent = parent;
        }

        public List<Node> getChildren() {
            return Collections.unmodifiableList(children);
        }

        public Node getChild(String data) {
            for (Node node : children)
                if (node.data.equals(data))
                    return node;

            return null;
        }

        public String getPath() {
            Deque<String> nodes = new LinkedList<>();
            Node node = this;

            while (node.parent != null) {
                nodes.addFirst(node.data);
                node = node.parent;
            }

            return String.join("/", nodes);
        }

        @Override
        public String toString() {
            return data;
        }
    }

    public static void main(String... args) {
        Tree tree = new Tree();
        tree.add("test/test2/test3");
        tree.add("test/test5/test2");
        tree.add("test/test7/test5/test4");
        tree.add("test/test7/test5/test9");

        Node node = tree.get("test/test7/test5/test9");
        String path = node.getPath();
    }

}