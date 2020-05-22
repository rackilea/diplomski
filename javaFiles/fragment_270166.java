public int removeLast(Node n){  //returns and removes the last node

    int x = getLast();
    if(n == start && n.link == null) //list has only last node
        start = null;
    else {
        if(n.link.link == null)
            n.link = null;
        else
            x = removeLast(n.link);
    }
    return x;
}