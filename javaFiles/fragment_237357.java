public E deleteAtGiven(int t){
    if(isEmpty()) 
        return null;
    throw new IndexOutOfBoundsException("List is Empty");
    else if (t<0 ||t>=size()){ 
        throw new IndexOutOfBoundsException("Invalid Position");
   }
}