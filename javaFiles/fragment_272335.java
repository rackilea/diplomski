public static void drawTriangle(int size) {
    for (int i = 1; i <= size + 1; i += 2) {
        for (int spaces = 0; spaces <= size - i; spaces++) {
            System.out.print(" ");
        }
        for (int hashes = 0; hashes < i; hashes++) {
           System.out.print("#");
        }
        System.out.println();
    }

    System.out.println();
}