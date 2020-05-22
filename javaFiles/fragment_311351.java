<!-- language: Java-->
   class TreeNode<E> {
    protected E element;
    protected TreeNode<E> left;
    protected TreeNode<E> right;
    public TreeNode(E e) {
    element = e;
    }
    }// Create the root node
    TreeNode<Integer> root = new TreeNode<>(60);
    // Create the left child node
    root.left = new TreeNode<>(55);
    // Create the right child node
    root.right = new TreeNode<>(100);
-But i don't know how to get it from db in lists and assign them so i can use them