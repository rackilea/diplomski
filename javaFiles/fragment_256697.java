public static Node reverse(Node head, Node tail) {
    Node first = head;
    Node last = tail;
    while (first != last && first.prev != last) {
        Node preFirst = first.prev;
        Node postFirst = first.next;
        Node preLast = last.prev;
        Node postLast = last.next;
        if (preFirst != null) {
            preFirst.next = last;
        }
        if (postLast != null) {
            postLast.prev = first;
        }
        last.prev = preFirst;
        first.next = postLast;
        if (last != postFirst){
            last.next = postFirst;
            postFirst.prev = last;
            first.prev = preLast;
            preLast.next = first;
            first = postFirst;
            last = preLast;
        } else {
            last.next = first;
            first.prev = last;
        }
    }
    Node result = tail;
    while (result.prev != null){
        result = result.prev;
    }
    return result;
}