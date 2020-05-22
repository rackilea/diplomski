public String dequeue() {
    if (isEmpty()) {
        throw new RuntimeException("Queue underflow");
    } else if (first == last) {
        String f = first.item;
        first = null;
        last = null;
        return f;
    }

    String f = first.item;
    first = first.next;
    return f;

}
public void enqueue(String item) {
    Node x = new Node(item);
    if (first == null && last == null) {
        first = x;
        last = x;
        return; // return back when first node is enqueued
    }
    last.next = x;
    last = x;
}