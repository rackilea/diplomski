public boolean removeFirstOccurrence(int value) {
    //don't do contains(), you are looping over the entire thing anyway doing it again is useless
    if(head==null)return false;
    if(head.value==value){//does head contain the value 
        head=head.next;
        size--;
        return true;
    }
    Node prev = head;
    while ((prev.next != null)) {//actually checking prev.next if it contains the value
        if (prev.next.value == value){
            prev.next=prev.next.next; //remove link from prev to prev.next 
            size--;
            return true;
        }
        prev = prev.next;
    }
    return false;
}

public boolean removeAll(int value) {
    if(head==null)return false;
    while(head.value==value){//does head contain the value 
        head=head.next;
        size--;
        result=true;
    }
    Node prev=head;
    while ((prev.next != null)) {//actually checking prev.next if it contains the value
        (prev.next.value == value){
            prev.next=prev.next.next; //remove link from prev to prev.next 
            size--;
            result = true;
        }else {
            prev = prev.next;
        }
    }
    return result;
}