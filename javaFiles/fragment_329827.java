void insert(Node nd) {
    Node temp = start;
    Node previous = null;

    while (temp != null && temp.d < nd.d) {
        previous = temp;
        temp = temp.link;
    }

    // insert node
    if (previous == null) {
        // insert at start
        nd.link = start;
        start = nd;
    } else {
        // insert somewhere in the middle
        nd.link = temp;
        previous.link = nd;
    }
}//insert