public static void printPyramid(int rows) {
        // row counter
        for (int i = 1; i <= rows; i++) {

            // padding- size = rows - i
            for (int j = 1; j <= rows - i; j++) {
                // 2 spaces - char + space
                System.out.print("  ");
            }

            // print numbers
            for (int j = -i; j <= i; j++) {
                // we want only once 1, and skip print zero
                if (j == 0 || j == 1) {
                    continue;
                }

                // print absolute value
                System.out.print(Math.abs(j) + " ");
            }

            // new row- println same as print("\n");
            System.out.println();
        }
    }