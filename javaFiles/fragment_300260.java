public void addLast(int x) {
    if (head == null) head = new Node(x, null);
    else {
        Node p = head;
        while (p.link != null) p = p.link;
        p.link = new Node(x, null); } }