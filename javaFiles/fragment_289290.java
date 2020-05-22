public HeapPriorityQueue(E[] theElements) {
    elements = theElements;
    size = theElements.length - 1;
    int len = theElements.length;
    for(int c= len - 1;c>=1; c --) {
        if(elements[c] != null) {
            if(hasLeftChild(c)){
                bubbleDown(c);
            }
        }          
    }
}