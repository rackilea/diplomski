public boolean foo(){
    ListNode current = front;
    while (current != null){
        if(current.next == null)
            return false;
        if(current.data != current.next.data)
            return false;
        current = current.next.next;
    }
    return true;
}