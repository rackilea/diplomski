public void addLast(T item) {
        if (sentinel == null) {
            sentinel = new Node(item, null);
            sentinel.next = sentinel;
        } else {
            sentinel.next = new Node(item, sentinel.nex);
            sentinel = sentinel.next;  // updatedSentinel
        }
        size++;
    }