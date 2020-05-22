private void DeleteItemHelper(final int indexToDelete, int curIndex, DLLNode curNode) {
    if (curIndex == indexToDelete) {
        // Handle removing a node with both a previous and next nodes.
    }

    else {
        DeleteItemHelper(indexToDelete, curIndex + 1, curNode.getNextNode());
    }
}


public void DeleteItem(int index) {
    DeleteItemHelper(index, 0, head);
}