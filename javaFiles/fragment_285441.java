public class Tree<T> {
    private Node<T> rootNode;
    private HashMap<Node<T>, List<Node<T>> tree;

    //and then some kind of function to go through the tree.
    public void expandNode(Node<T> node) {
        if (tree.get(node) == null) {
            System.out.println(node);
            return;
        }
        for(Node<T> n : tree.get(node)) {
            System.out.println(node);
            expandNode(n);
        }
    }
}