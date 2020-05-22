MergePoint (LinkList list1, LinkList list2) {
    p = list1.head;
    while (p != null) {
        q = list2.head;
        while (q != null) {
            if (p == q){
                    System.out.print(p.value + " is the Merging node");
                    return;
            }
            q = q.next;
        }        
        p = p.next;
    }    
}