public void remove(int n)
   {
       LinkEntry<E> remove_this = new LinkEntry<E>();
      //if remove_this is located in the middle of the list, enter this loop until it is
       //found, then remove it, closing the gap afterwards.
       int i = 0;
       boolean removed = false;
       remove_this = head;

       while(removed == false){
           //if nothing comes before remove_this, set the head to equal the element after remove_this
           if (remove_this.previous == null){
               head = remove_this.next;
               head.previous = null;
               removed = true;
           }

           //if nothing comes after remove_this, set the tail equal to the element before remove_this
           else if (remove_this.next == null){
               tail = remove_this.previous;
               tail.next = null;
               removed = true;
           }
           //otherwise set the next element's previous pointer to the element before remove_this
           else{
               //if i == n, stop and delete 'remove_this' from the list
               if (i == n) {               
                   //set the previous element's next to the element that comes after remove_this
                   remove_this.previous.next = remove_this.next;
                   //set the element after remove_this' previous pointer to the element before remove_this
                   remove_this.next.previous = remove_this.previous;
                   removed = true;
                   break;
               }
               //if i != n, keep iterating through the list
           }
           if(!removed){
               remove_this = remove_this.next;
           }
           i++; 
       }
   }