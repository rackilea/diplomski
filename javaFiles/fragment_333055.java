public static void xmasTree() {
    int width = height * 2 - 1;
    int stem = width - 2*width/3; 
    // NESTED LOOPS
    // first for loop to print amount of rows
    for (int i = 0; i < height; i++) {
        // second for loop for print out spaces to match the tree level
        for (int j = 0; j < height - i; j++) {
            System.out.print(" ");
        }
        // third for loop to print out stars
        for (int k = 0; k < (2 * i + 1); k++) {
            System.out.print("*");
        }
        System.out.println();
    }
    // first for loop to determine amount of rows for bottom
    for (int i = 0; i <= (height - 1) / 5 + 1; i++) {
        // for loop to print the bottom part of the tree
        for (int j = 0; j <= width / 3; j++) {
            System.out.print(" ");
        }
        //here we put the formula to use, instead of using width/3, the equivalent is used, that takes rounding into account.
        for (int j = 0; j < width - 2*(width/3); j++) {
            System.out.print("*");
        }
        System.out.println();

    }