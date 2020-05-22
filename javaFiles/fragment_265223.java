//in [1,2,3,null]
Node reverse(Node n){

    //base case
    if(n == null)
    {
        return null;
    }

    // returns [null,3,2,1]
    Node next = reverse(n.getNext());
    next.setNext(n);// set the next nodes next to its previous(n on unwinding)
    return n;
}