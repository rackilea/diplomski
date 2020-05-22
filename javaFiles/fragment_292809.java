for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
        if (i >= j) {
            System.out.print(" x ");
        } else {
            System.out.print(" o ");
        }
    }
    System.out.println();
}