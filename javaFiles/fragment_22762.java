while(current != null) {
    for(Node prev=current; prev != null && prev.prev != null; prev = prev.prev) {
        if(prev.data.compareTo(prev.prev.data) <= 0) {
            if (prev==current) {
                current=prev.prev;
            }
            swap(prev,prev.prev);
        }
    }
    current = current.next;
}