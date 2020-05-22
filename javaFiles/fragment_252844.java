int CompareLists(Node headA, Node headB) {    
    Node tmpA = headA;
    Node tmpB = headB;

    if(tmpB.next != null && tmpA.next == null) return 0;

    while(tmpA.next != null) {    
        if(tmpB.next == null || tmpA.data != tmpB.data) return 0;

        tmpB = tmpB.next;
        tmpA = tmpA.next;  
    }

    //Added:
    if(tmpB.next != null || tmpA.data != tmpB.data)  return 0;
    return 1;
}