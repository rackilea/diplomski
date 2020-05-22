public void add(int data) {
    Link newLink = new Link(data);
    if (first == null) {
        first = last = newLink;
    } else {
        last.next = newLink; // First set the next pointer of the last node to the new node
        last = newLink; // Once the pointer is set, now set last node properly
    }
}