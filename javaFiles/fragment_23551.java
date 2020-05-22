public void swap(int i, int j) {
    Order temp = maxHeap.get(i);
    maxHeap.setElementAt(maxHeap.get(j), i);
    maxHeap.setElementAt(temp, j);
    swapCounter++;
}