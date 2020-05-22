Node prevNode = findNode(node);

if(node == first) {
    first = node.next;
    last.next = first;
}
else if(node == last) {
    prevNode.next = first;
    last = prevNode;
}
else {
    prevNode.next = node.next;
}