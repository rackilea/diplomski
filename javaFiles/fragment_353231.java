public static void body2() {
    for (int i = 3; i > 0; i--) {
        System.out.print("|");

        for (int j = 1; j <= 3 - i; j++) {
            System.out.print(".");
        }

        for (int k = 1; k <= i; k++) {
            System.out.print("\\/");
        }

        for (int l = 1; l <= 3 - i; l++) {
            System.out.print("..");
        }

        for (int m = 1; m <= i; m++) {
            System.out.print("\\/");
        }

        for (int n = 1; n <= 3 - i; n++) {
            System.out.print(".");
        }

        System.out.print("|");
        System.out.println();
    }
}