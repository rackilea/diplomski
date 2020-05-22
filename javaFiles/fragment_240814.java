...
Node earlierNode = rootNode;
for (int j = 0; j < i; j++) {
    if (earlierNode.getInfo().equals(node.getInfo())) {
        isDistinct = false;
    }
    earlierNode = earlierNode.getNext();
}
...