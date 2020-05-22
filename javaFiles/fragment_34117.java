for (int x = 1; x <= input; x++)
    {
        for (int y = 0; y < input - x; y++) {
            System.out.print(" ");
        }
        for (int y = 0; y < x; y++) {
            System.out.print("x ");
        }
        System.out.println();
    }