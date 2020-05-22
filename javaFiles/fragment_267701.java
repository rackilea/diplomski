public static void main(String[] args){
    Recipient r1; // with isDateLastContactNull() == true;
    Recipient r2; // with isDateLastContactNull() == false;
    RecipientComparator rc = new RecipientComparator();

    System.out.println(rc.compare(r1, r2)); // -1
    System.out.println(rc.compare(r2, r1)); // -1
    // both print -1 which is not transitive.
}