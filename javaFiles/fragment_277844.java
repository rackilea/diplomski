public class Main {

    public static class Node {
        public int level;
        public String content = "";
        public List<Node> children = new ArrayList<>();
    }

    public static void main(String[] args) {

        String input="{\\\\*\\\\listtable{\\\\list{\\\\listlevel{\\\\leveltext}{\\\\levelNumber}}}}";

        Node root = null;
        Stack<Node> stack = new Stack<>();

        for(char c: input.toCharArray()) {
            if (c == '{') {
                Node n = new Node();
                n.level = stack.size() + 1;
                n.content += c;
                stack.push(n);
                if (root == null) root = n;
            } else if (c == '}') {
                Node n = stack.pop();
                n.content += c;
                if (!stack.isEmpty()) {
                    stack.peek().children.add(n);
                }
            } else {
                stack.peek().content += c;
            }
        }

        TreeTraverser<Node> treeTraverser = new TreeTraverser<Node>() {
            @Override
            public Iterable<Node> children(Node root) {
                return root.children;
            }
        };

        for(Node node : treeTraverser.preOrderTraversal(root)) {
            String indent = String.format("%" + node.level + "s", " ");
            System.out.println(indent + node.content);
        }
    }
}