public static void main(String[] args) {
    // a is assigned the value 1
    int a = 1;
    // a is incremented (now 2) and THEN b is assigned the value of a (2) 
    // b is now 2 and so is a.
    int b = ++a;

    System.out.println(b);
    // if you had printed a here it would have been 2 so is b.
}