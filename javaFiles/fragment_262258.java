public void addFirst(Item item){
    Node h = deque.getHead();
    if(h == null) {
        h = new Node(item);
        Node t = deque.getTail();
        t = new Node(item);
        h.next = t;
        t.prev = h;
        numNodes++;
        deque.head = h;
        deque.tail = t;
    }