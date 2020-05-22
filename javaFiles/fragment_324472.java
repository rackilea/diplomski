public Object pop() throws StackException{
    if (!isEmpty()) {
        Node temp = top;
        top = top.getNext();
        return temp.getItem();
    } else {
        throw new StackException("StackException on " + "pop: stack empty");
    }
}