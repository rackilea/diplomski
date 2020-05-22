public Integer next() {
    while (nextNode != null){
            int data = nextNode.data;
            nextNode = nextNode.next_;
            if (data % 2 != 0){
                return data;
            }
    }
    //no odd element was found
    throw new NoSuchElementException();
}