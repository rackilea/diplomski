private void rebuild() {
    HeapQueue reHeap = new HeapQueue();
    reHeap.setComparator(comparator);
    for (int i = 0; i < queue.size(); i++) {
        reHeap.offer(queue.get(i));
    }
    queue = reHeap.queue;
}