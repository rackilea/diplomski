public static void main(String[] args) {
    for (int i = 10; i >= 1; i--) {
        for (int j = 10; j >= i; j--) {
            if (j % 2 == 0) {
                System.out.print("*");
            } else {
                System.out.print("-");
            }
        }
        System.out.println();
    }

    for (int i = 9; i >= 0; i--) {
        for (int j = 0; j < i; j++) {
            if (j % 2 == 0) {
                System.out.print("*");
            } else {
                System.out.print("-");
            }
        }
        System.out.println();
    }
}