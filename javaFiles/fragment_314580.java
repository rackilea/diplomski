public void DisplayItem() {
    if (head == null) {
        return;
    }

    Node current = head;

    while (current != null) {
        System.out.println(current.getNodeItem().toString());
        current = current.getLink();
    }
}