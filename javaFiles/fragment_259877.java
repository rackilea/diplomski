public String removeBoxcarFromEnd() {
    String result;
    if(head == null) {  //empty list
        return null;      //or do something else? throw an exception?
    } else if (head.next() == null) {  //one element, remove it
        int result = head.data();
        head = null;
    }    
    else {  //more elements
        Boxcar prevcar = head, nextcar = head.next(), ffcar = nextcar.next();
        while (ffcar != null) {  //double next iteration
            prevcar = nextcar;
            nextcar = ffcar;
            ffcar = ffcar.next();
        }
        int result = nextcar.data(); //get result
        prevcar.setNext(null);       //remove it from the linked list
    }
    size--;
    return result;
}