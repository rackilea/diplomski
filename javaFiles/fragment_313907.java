public static void zigZag(Node upper, Node lower, Node temp){
    if(temp == null) // temp got set to null by lower.next or upper.next
        return;   // we're done
    upper = temp;
    temp = lower.next;
    lower.next = upper;
    zigZag(lower, upper, temp); //swap upper/lower for next cycle
}