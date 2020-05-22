@Override
public void forEachRemaining(Consumer<? super Node> action) {
    Node current = pendingNode;
    if(current != null) {
        pendingNode = null;
        action.accept(current);
    }
    for(;;) {
        current = pending.poll();
        if(current == null) break;
        traverseLocal(action, current);
    }
}
private void traverseLocal(Consumer<? super Node> action, Node current) {
    do {
        action.accept(current);
        Node child = current.getLeft();
        if(child!=null) traverseLocal(action, child);
        current = current.getRight();
    } while(current != null);
}