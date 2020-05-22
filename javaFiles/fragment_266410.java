private void foo(Item item) {
    Node<Item> oldNode = new Node<Item>(item); // declaration using generics.
    Item data = oldNode.data; // compiles fine

    Node oldNode2 = new Node(item); // un-generic declaration. Compiler doesn't know if it's node a Node of something else.
    Item data = oldNode2.data; // compile error: type mismatch: cannot convert Object to item.
}