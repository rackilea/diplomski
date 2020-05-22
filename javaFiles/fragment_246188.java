int i = 100;  // this is our outer loop control variable
while (i > 0) {
    int j = 0;  // this is our inner loop control variable
    while (j < i) {
        System.out.print("*");
        j++;
    }
    System.out.println();
    i--;
}