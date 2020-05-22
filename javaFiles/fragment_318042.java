public abstract class Node<T extends Node<?>> {
    public abstract T[] getChildren();
}

class NumberNode extends Node {
    int data;
    public Node[] getChildren() {return new Node[]{};}
}

class IdentifierNode extends Node {
    int data;
    public Node[] getChildren() {return new Node[]{};}
}

class PlusNode extends Node {
    NumberNode left;
    NumberNode right;
    public NumberNode[] getChildren() {return new NumberNode[]{};}
}