while (a > 1) {
        if ((a % 2) == 0) {
            a /= 2;
            System.out.print("  " + a);
        } else {
            a = (a * 3) + 1;
            System.out.print("  " + a);
        }
    }