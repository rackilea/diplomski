public Student remove(Student items) {
    LinearNode  previous = null,
                current = head;

    // iterate over all the nodes starting at the head, maintaining a reference to the previous node as you go          
    while (current != null && current.items.compareTo(items) != 0) {
        previous = current;
        current = current.next;
    }

    // At this point you have either a) found the Node with matching items or b) not found it
    if (current == null) {
        // not found in the list
        return null;
    }

    // At this point you know where the Node is, and you have a reference previous node as well 
    // so it's easy to reattach the linked list to remove the node
    if (previous == null) {
        // The head node was the match if previous is not set, so make sure to update the head Node accordingly
        head = current.next;
    }
    else {
        previous.next = current.next
    }

    return current.items;
}