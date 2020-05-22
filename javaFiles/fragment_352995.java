... else {
    current = current.right;
    if (current == null) {
        parent.right = newNode;
        return;
    }
}