private static void iterateall(BinaryTree foo) {
    Stack<BinaryTree> nodes = new Stack<BinaryTree>();
    nodes.push(foo);
    while (!nodes.isEmpty()) {
        BinaryTree node = nodes.pop();
        if (node == null)
            continue;
        System.out.println(node.node);
        nodes.push(node.right);
        nodes.push(node.left);
    }
}