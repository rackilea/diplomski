public static void eraseMap(int width, int height) {
    for (int i = 0; i < width; ++i) {
        for (int j = 0; j < height; ++j) {
            System.out.print(Config.UNSWEPT + " ");
        }
        System.out.println();
    }
}