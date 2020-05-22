while (front.data == value) { // If match on first elem
    front = front.next;
    if (front == null) {
        return;
    }
}