for (int i = 1; i <= 6; i++) {
    for (int k = 1; k <= 6; k++) {
        if (k == i) {
            System.out.print(2 * k);
        } else {
            System.out.print("-");
        }
    }
    System.out.println("");
}