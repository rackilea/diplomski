public void addToEnd(int data) {
    Node p = head;
    if( p == null) {
        head = new Node(data, null);
    } else {
        while (p.link != null)
            p=p.link;
        p.link=new Node(data, null);
    }
}