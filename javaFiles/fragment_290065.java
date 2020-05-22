public class BinaryTree {
    private static class TreeNode { ... }

    public TreeNode root;

    public BinaryTree(){
        root = null;
    }

    public void insert(int x) {
        root = insert(root, x);
    }

    private TreeNode insert (TreeNode node, int x) {
        if (node == null) {
            return new TreeNode(x);
        }
        if (node.key > x)
            node.left = insert(node.left, x);
        else if (node.key < x)
            node.right = insert(node.right, x);
        return node;
    }
 }