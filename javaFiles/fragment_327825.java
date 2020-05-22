public int indexOf(Object input) {       
    int index = 0;    
    while(myAsetIterator.hasNext()) {
        index++;
        if (input.equals(myAsetIterator.next())) {
            return index;
        }
    }
    return -1;
}

public boolean contains(Object input) {
    return indexOf(input) == -1;
}