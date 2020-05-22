public static void main(String[] args) {
    // a is assigned the value 1
    int a = 1;
    // b is assigned the value of a (1) and THEN a is incremented.
    // b is now 1 and a is 2.
    int b = a++;

    System.out.println(b);
    // if you had printed a here it would have been 2
}