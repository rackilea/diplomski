public class BinaryTree {
    Node root;

    BinaryTree(int d) {
        root = new Node(d);
    }

    BinaryTree() {
        root = null;
    }

    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        BinaryTree t = new BinaryTree(5);
        t.root.left = new Node(6);
        t.root.right = new Node(4);
        t.root.left.left = new Node(7);
        t.root.left.right = new Node(8);
        t.root.right.left = new Node(9);
        t.root.right.right = new Node(10);
        t.printTree(t.root);
        Node MirroredNode = t.mirror(t.root.clone());
        System.out.println();
        t.printTree(t.root);
        t.printTree(MirroredNode);
        System.out.println();
        System.out.print(t.isSymmetric(t.root));
    }

    boolean isSymmetric(Node root) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;
        Node root2 = mirror(root.clone());
        printTree(root);
        System.out.println();
        printTree(root2);//this should print mirror image of tree but it is printing the original tree
        return isMirror(root, root2);
    }

    Node mirror(Node root) {
        if (root == null)
            return root;
        if (root.left == null && root.right == null) {
            return root;
        }
        Node left = mirror(root.left.clone());
        Node right = mirror(root.right.clone());
        root.left = right;
        root.right = left;
        return root;
    }

    boolean isMirror(Node n1, Node n2) {
        if (n1 == null && n2 == null)
            return true;
        if (n1 == null || n2 == null)
            return false;
        if (n1.data != n2.data)
            return false;
        return isMirror(n1.left, n2.right) && isMirror(n1.right, n2.left);
    }

    void printTree(Node root) {
        Queue<Node> q = new LinkedList<Node>();
        if (root != null) {
            q.add(root);
        } else {
            System.out.println("empty tree");
        }
        while (!q.isEmpty()) {
            Node y = q.remove();
            System.out.print(y.data + " ");
            if (y.left != null)
                q.add(y.left);
            if (y.right != null)
                q.add(y.right);
        }
    }

    static class Node implements Cloneable {//why static is needed ?
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = null;
            right = null;
        }

        @Override
        public Node clone() {
            try {
                return (Node) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}