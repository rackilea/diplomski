if (front == n) {
    front = n.tail;
} else {  
    for (ListNode<Job> curr = front; curr !=null; curr = curr.tail) {  
        if (curr.tail == n) {
            curr.tail = n.tail;
            break;
        }      
    } 
}