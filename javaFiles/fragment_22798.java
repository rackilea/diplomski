public void setAt(int pos, int value){
    DNode current = header;
    for(int i = 1; i <= pos && current != null; i++){
        current = current.next;
    }
    if(current != null)
        current.setElement(value);
    else
        throw new IndexOutOfBoundsException();
}