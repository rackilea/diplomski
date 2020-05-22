if(value && queue.size() == CAPACITY - 1) {
    /*
     * Element has been *actually consumed* *from full queue*
     * (previousely .size() = CAPACITY), thus *queue become non full*.
     */
    bufferNotEmpty.signalAll();
}