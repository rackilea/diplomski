static int biggest(int n) {
    int n1 = n%10;
    int n2 = n/10;

    if (n2 == 0) { // base case
        return n1;
    }
    int n3 = biggest(n2); // recurse here
    return n1 > n3 ? n1 : n3; // return the max
}