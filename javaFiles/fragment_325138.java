if (counter == 3) {
    child.visited(true);
    printNode(child);
    q.add(child);
    paintQueue.add(child);
}