if(isAdded && queue.size() == 1) {
    /*
     * Element has been *actually added* *into empty queue*
     * (previously .size() = 0), thus *queue become non-empty*.
     */
    bufferNotFull.signalAll();
}