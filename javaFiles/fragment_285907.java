public Number(int n) {
        number = n;
        head = new Node(0);
        Node prev = head;
        for (int i = 1; i <=number; i++) {
            Node node = new Node(i);
            prev.next=node; // head I will have 1, 2, 3... n
            prev=node;
        }
        tail=prev;
    }