private int finalIndexOf(L element) {
    int index = 0;
    int result = -1;
    Node<L> node = head;
    while (node != null) {            
        if (node.data != null && node.data.compareTo(element) == 0) {
            result = index;
        }
        node = node.next;
        index++;
    }
    return result;
}