// There is probably a smarter way to do this
public static TreeNode buildTree(boolean[] word, int key) {
    Deque<TreeNode> stack = new ArrayDeque<>();
    boolean insertRight = false;
    TreeNode root = null;
    TreeNode currentNode = null;
    for (int i = 0; i < word.length; i++) {
        if (word[i]) {
            TreeNode previousNode = currentNode;
            currentNode = new TreeNode(key);

            if (root == null) {
                root = currentNode;
            } else if (insertRight) {
                previousNode.setRight(currentNode);
                insertRight = false;
            } else {
                previousNode.setLeft(currentNode);
            }

            stack.push(currentNode);
        } else {
            currentNode = stack.pop();
            insertRight = true;
        }
    }
    return root;
}