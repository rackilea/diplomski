public void remove(E e){
    prev = head;
    removeElement(e, head);
    System.gc();
}

private void removeElement(E e, Node currentElement) {
    if(currentElement==null){
        return;
    }
    if(head.getData().equals(e)){
        head = head.getNext();
        size--;
    }else if(currentElement.getData().equals(e)){
        prev.setNext(currentElement.getNext());
        size--;
    }
    prev = prev.getNext();
    removeElement(e, currentElement.getNext());

}