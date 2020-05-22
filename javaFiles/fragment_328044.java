public static void main(String[] args) {
    System.out.println("Example 1. Expected output: 1 3 2 4 7 ");

    BinaryTree tree_level = new BinaryTree();
    tree_level.root = new Node(1);
    tree_level.root.left = new Node(2);
    tree_level.root.right = new Node(3);
    tree_level.root.left.left = new Node(4);
    tree_level.root.right.right = new Node(7);

    tree_level.printLevelOrder();
    System.out.println();
    tree_level.printLevelOrderFixed();
    System.out.println();

    System.out.println("Example 2. Expected output: 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 ");
    /*             1
     *         3       2
     *       4   5   6   7
     *      5 4 3 2 1 0 9 8
     *     6               7
     *    9                 8
     */
    BinaryTree tree_level2 = new BinaryTree();
    tree_level2.root = new Node(1);

    tree_level2.root.left = new Node(3);
    tree_level2.root.right = new Node(2);

    tree_level2.root.left.left = new Node(4);
    tree_level2.root.left.right = new Node(5);
    tree_level2.root.right.left = new Node(6);
    tree_level2.root.right.right = new Node(7);

    tree_level2.root.left.left.left = new Node(5);
    tree_level2.root.left.left.right = new Node(4);
    tree_level2.root.left.right.left = new Node(3);
    tree_level2.root.left.right.right = new Node(2);
    tree_level2.root.right.left.left = new Node(1);
    tree_level2.root.right.left.right = new Node(0);
    tree_level2.root.right.right.left = new Node(9);
    tree_level2.root.right.right.right = new Node(8);

    tree_level2.root.left.left.left.left = new Node(6);
    tree_level2.root.right.right.right.right = new Node(7);
    tree_level2.root.left.left.left.left.left = new Node(9);
    tree_level2.root.right.right.right.right.right = new Node(8);

    tree_level2.printLevelOrder();
    System.out.println();
    tree_level2.printLevelOrderFixed();
    System.out.println();
}