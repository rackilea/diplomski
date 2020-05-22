while(current != null){
    if(min > current.data){
        min = current.data;
    }
    current = current.next;
}