...
else {
// head == current and if we get here, the if branch has not fired
StudentLLNode previous, next;
previous = current;
current = current.getNext();
while(current != null){
   next = current.getNext();
   if(s.getId() == (current.getStd().getId())){  
        previous.setNext(next); //doesn't matter if next is null or not
        size--;
        return true;
   } 
   previous = current;
   current = next;
}
...