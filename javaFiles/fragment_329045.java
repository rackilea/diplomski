public int get(int index){
    Node head = this.head;
    for(int i = 0; i < index; i++){
         head = head.next;
    }
    return head.getData();
 }