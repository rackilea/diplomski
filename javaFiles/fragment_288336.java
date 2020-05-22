private void popBack(){
    if(!isEmpty()) {
        --size;
        T temp = tail.info;
        tail = tail.prev;
        tail.next = null;
        System.out.println(temp);
    }
}