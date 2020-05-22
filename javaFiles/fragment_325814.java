while (anEntry != currentNode.data) {
    currentNode = currentNode.next;
    index++;
    if (anEntry.equals(currentNode.data)){
        return index;
    }
}
return -1;