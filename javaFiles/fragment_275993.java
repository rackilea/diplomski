public Set complement(Set a) {
    Set c = new Set();
    Node curC = c.head;
    Node cur = head.next;

    while (cur != null) {  
        if (!a.otherContain(cur.object)) {
            Node newNode = new Node();
            newNode.object = cur.object;
            newNode.next = null;
            curC.next = newNode;
            curC = curC.next;
        }
        cur = cur.next;
    }
    return c;
}