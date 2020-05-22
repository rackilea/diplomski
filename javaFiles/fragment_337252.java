removeDuplicates(Node head) {
    if (head == null) {
        throw new RuntimeException("Invalid List");
    }

    Node current = head;
    Node prev = null;
    Set<T> data = new HashSet<T>(); // where T is the type of your data and assuming it implements the necessary methods to be added to a Set properly.
    while (current != null) {
        if (!data.contains(current.data)) {
            data.add(current.data);
            prev = current;
            current = current.next;
        } else {
            if (prev != null) {
                prev.next = current.next;
                current = current.next;
            }
        }
    }
}