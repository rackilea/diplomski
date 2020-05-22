public Object removeLast(){
    if (last == null){
        throw new NoSuchElementException();
    }
    Node temp = last;
    last = last.previous;
    last.next = null;
    temp.previous = null;
    return temp.data;
}