public void add(int val) {
    if (root == null) {
        root = new Node(val);
    }
    Node cur = root;
    Node next = null;
    while (true) {
        next = findNodeLocation(cur, val);
        if (next != cur) {
            cur = next;         
        } else {
            break;
        }
    }
    if (val < cur.value) {
        cur.leftChild = new Node(val);
    } else {
        cur.rightChild = new Node(val);
    }
}