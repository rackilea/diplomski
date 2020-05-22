static void drawbox(int x, int y) {
    for (int i = 0; i < y; i++) {
        System.out.print("*");
    }
    System.out.println();
    for (int i = 0; i < x - 2; i++) {
        System.out.print("*");
        for (int j = 0; j < y - 2; j++) {
            System.out.print(" ");
        }
        System.out.println("*");
    }
    for (int i = 0; i < y; i++) {
        System.out.print("*");
    }
    System.out.println();
}