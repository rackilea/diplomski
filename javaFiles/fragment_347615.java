public void addLast(T item) {
        if (sentinel == null) {
            sentinel = new Node(item, null, null);
            sentinel.next = sentinel;
            sentinel.prev = sentinet;
        } else {
            Node next = sentinel.next;
            sentinel.next = next.prev = new Node(item, next, sentinel);
            sentinel = sentinel.next;
        }
        size++;
    }