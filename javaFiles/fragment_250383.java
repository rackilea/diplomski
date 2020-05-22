public class RandomBinaryTree {
    private Random random = new Random();

    public TreeNode binaryTreeGenerator(int n, int key){
        if (n == 0)
            return null;

        TreeNode root = new TreeNode(key);

        // Number of nodes in the left subtree (in [0, n-1])
        int leftN = random.nextInt(n);

        // Recursively build each subtree
        root.setLeft(binaryTreeGenerator(leftN, key));
        root.setRight(binaryTreeGenerator(n - leftN - 1, key));

        return root;
    }
}