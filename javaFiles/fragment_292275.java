for (int i = 0; i < 7; i++) {
        for (int j = 0; j < 7; j++) {
            if ((i < 4 && j >= i + 1 && j < 6 - i) || (i > 3 && j < i && j >= 7 - i)) {
                System.out.print("  ");
            } else {
                System.out.print("* ");
            }
        }
        System.out.println();
    }