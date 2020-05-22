public void push(Object val) {
    if(!isFull()) {
        counter++;
        Node lastTop = top;
        top = new Node(val);
        top.setNext(lastTop);
    }
}