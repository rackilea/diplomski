int d = 2, n = 6;
    int tempD = d - 1;
    for (int line = 1; line <= n; line++) {
        tempD = tempD + line;
        if (tempD > 9) {
            tempD = tempD - 9;
        }
        d = tempD;
        for (int j = 2; j <= line; j++) {
            System.out.print("  ");
        }
        for (int k = line; k <= n; k++) {
            System.out.print(d + " ");
            d = d + k;
            if (d > 9) {
                d = d - 9;
            }
        }
        System.out.println();
    }