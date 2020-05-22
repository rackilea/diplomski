public Object pop() {
    if(!isEmpty()) {
        counter--;
        Node lastTop = top;
        top = top.getNext();
        return lastTop.getElement();
    } else {
        return null;
    }
}