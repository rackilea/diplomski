public String toString(){
     String toReturn = "[ " + this.data;

     Node current=this.next;
     while (current!=null && current != this){ // <- cycle protection
         toReturn+=" -> " + current.data;
         current=current.next;
     }
     toReturn+=" ]";
     return toReturn;
 }