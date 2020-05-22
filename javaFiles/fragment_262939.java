public Integer get(int key) {
    Integer value = -1;
    Node old = cache.get(key);
    if (old != null){
        //move to tail
        /////Node node = new Node(key, old.getValue());
        removeNode(old);
        moveToTail(old);
        value = old.getValue();
    }
    return value;
}
public void put(int key, int value) {
    Node n = null;
    n = cache.get(key);
    if (n != null){
        //Update the value of node and move
        n.setValue(value);
        removeNode(n);
        size--;
    }
    else {
       n = new Node(key, value);
    }

    //move to tail
    moveToTail(n);
    cache.put(key, n);
    size++;
    //remove node if size upper than capacity
    while (capacity < size){
        Node rm = head.getNext();
        cache.remove(rm.getKey());
        removeNode(rm);
        size--;
    }
}