public static void zigZag(Node upper, Node lower, Node temp){
    int i = 0; //Controls alternation
    while(temp != null){ //Until temp gets set to null by lower.next or upper.next
        if(i%2==0){ //On even iterations
            upper = temp;
            temp = lower.next;
            lower.next = upper;
        }
        else{ //On odd iterations
            lower = temp;
            temp = upper.next;
            upper.next = lower;
        }
        i++;
    }
}