final int rows = 10;
    for(int row = 1; row <= rows; row++) {
        for(int i = 0; i < (rows - row); i++) {
             System.out.print(" ");
        }
        for(int i = 0; i < (row); i++) {
             System.out.print("*");
        }
        System.out.println();
    }