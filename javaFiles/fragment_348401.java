public void insert(int priority, int data) {
    Item item = new Item(priority, data);

    if (head == null) {
        head = item;
        item.setNext(null);
    } else {
        Item next = head;
        Item prev = next;

        do {
            if (priority > next.getPriority()) {
                // break and insert
                break;
            }
            prev = next;
            next = next.getNext();
        } while (next != null);

        item.setNext(next);
        if (item.getPriority() > head.getPriority()) {
            head = item;
        } else prev.setNext(item);
    }
}