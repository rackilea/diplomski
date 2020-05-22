public static void main(String[] args) {
    for (int i = 0; i <= 5; i++) {
        System.out.println();
        if (i < 2) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");

            }
        } else {

            System.out.print("***");
        }

    }
}