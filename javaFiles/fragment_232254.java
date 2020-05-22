public class MyClass {
    static class Node {
    public String name;
    public Node left;
    public Node right;

    Node(String name) {
        this.name = name;
        right = null;
        left = null;
    }

    @Override
    public String toString() {
        return "name = " + name + " hasLeft = " + (left != null) + " hasRight = " + (right != null);
    }

}

static class Tree {

    Node root;

    public Node getRoot() {
        return root;
    }

    private Node addRecursive(Node current, String value) {
    if (current == null) {
        return new Node(value);
    }

    if (value.compareTo(current.name) < 0) {
        current.left = addRecursive(current.left, value);
    } else if (value.compareTo(current.name) > 0) {
        current.right = addRecursive(current.right, value);
    } else {
        // value already exists
        return current;
    }

    return current;
    }

    public Tree add(String value) {
        root = addRecursive(root, value);
        return this;
    }

    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.name);
            traverseInOrder(node.right);
        }
    }

    public void traverseInOrder() {
        traverseInOrder(root);
         System.out.println("");
    }

}

public static void main(String args[]) {
    Tree tree = new Tree();
    tree.add("a").add("ab").add("bbb").add("cc").add("zolko").add("polip").traverseInOrder();

    Node found = getNode(tree.getRoot(),"vv");
    System.out.println(found);
    found = getNode(tree.getRoot(),"ab");
    System.out.println(found);
    found = getNode(tree.getRoot(),"polip");
    System.out.println(found);
    found = getNode(tree.getRoot(),"java");
    System.out.println(found);
    found = getNode(tree.getRoot(),"zolko");
    System.out.println(found);

}

public static Node getNode(Node currentNode, String name){
    // Base case: currentNode is null, nothing left to search
    if (currentNode == null) {
        return null;
    }

    Node retrieved = null;
    if (currentNode.name.equals(name)) {
        return currentNode;
    } else {
        // Tail recursions
        if(currentNode.left == null) {
            return getNode(currentNode.right, name);
        }
        else if(currentNode.right == null) {
            return getNode(currentNode.left, name);
        }
        // Non Tail recursion
        else {
        retrieved = getNode(currentNode.left, name);

            // If not found in left subtree, then search right subtree
            if (retrieved == null){
                retrieved = getNode(currentNode.right, name);
            }
        }
    }
    return retrieved;
}
}