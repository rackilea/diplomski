private Node add(Node root, String key, int d){
    char c;
    if (d != key.length()) c = key.charAt(d);
    else c = '$';
    if (root == null) root = new Node(c);
    if (d == key.length()) { return root; }
    if (c != root.value) root.next = add(root.next, key, d);
    else root.child = add(root.child, key, d+1);
    return root;
}