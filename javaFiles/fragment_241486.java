for (int i = 1; i <= 7; i++) {
    for (int j = 1; j <= i; ++j) {
        System.out.print(j);
    }
    for (int k = 7 - i; k >= 1; k--) {
        System.out.print("*");
    }
    System.out.println("");
}