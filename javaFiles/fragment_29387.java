if (a > b) {
    System.out.println("Inside test a>b : a is=" + a + " and b=" + b);
    return computeGcd(a, b); // <-- add return
} else { // if (b > a) {
    System.out.println("Inside test a<b : a is=" + a + " and b=" + b);
    return computeGcd(b, a); // <-- add return
}