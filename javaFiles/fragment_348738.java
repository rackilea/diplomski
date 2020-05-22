for (int i=1; i <= 5; i++) {
    // print 5 minus i spaces
    for (int j=5; j >= i + 1; j--) {
        System.out.print(" ");
    }
    // repeat the ith digit i times
    for (int k=0; k < i; ++k) {
        System.out.print(i);
    }
    System.out.print("\n");
}