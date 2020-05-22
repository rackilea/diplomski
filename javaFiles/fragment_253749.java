private static void switchOnIntegerPolarity() {
        int a = 1;
        int b = 2;
        int c = 3;
        int d = (int) Math.pow(b ^ 2 - 4 * a * c, 0.5);
        int r1 = (-(b) - (d)) / 2 * (a);
        int r2 = (-(b) + (d)) / 2 * (a);

        switch ((int) Math.signum(d)) {
        case 0: // Zero
            System.out.println("1 solutions: r1; " + r1 + " and r2" + r2);
            break;
        case 1: // 'd' is Positive
            System.out.println("2 solutions: r1; " + r1 + " and r2" + r2);
            break;
        case -1: // 'd' is Negative
            System.out.println("no real solution");
            break;
        }
    }