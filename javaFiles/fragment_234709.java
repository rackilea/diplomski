public void removeLast() {
    Customer temp = listPtr;  
    while(temp.next.next!=null){
        temp = temp.next;
    } 
    temp.next=null;   
}