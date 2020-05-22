public displayWithForLoop() {
    Node pointer = head;
    for (int i = 0; i < size - 1; i++) {
        System.out.println(pointer.element);
        pointer = pointer.next;
    }
}