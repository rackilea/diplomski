public String reduceList() {
    Node curNode = first;
    while(first != last) {
        removeNode(curNode.getNext().getNext());
        curNode = curNode.getNext().getNext();
    }

    return first.getValue();
}