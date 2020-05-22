public boolean add(E element) 
    {
        LLNode<E> newNode = new LLNode<E> (element);
        if (element == null) {
            throw new NullPointerException("Element can not store a null reference!");
        } else {
            newNode.next = tail;       // set new.next to tail
            newNode.prev = tail.prev;  // set new.prev to prior last
            tail.prev.next = newNode;  // set prior last.next to new last
            tail.prev = newNode;       // set tail.prev to new last
            size++;
        }
        return true;
    }