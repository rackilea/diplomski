int maxOfFive (int a, int b, int c, int d, int e) {
    int largest = a;
    if (b > largest) largest = b;
    if (c > largest) largest = c;
    if (d > largest) largest = d;
    if (e > largest) largest = e;
    return largest;
}