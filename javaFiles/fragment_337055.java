private static Coord fillMatrix() {
    Scanner sc = new Scanner(System.in);
    int size = sc.nextInt();
    matrix = new Integer[size][size];
    Coord coord = new Coord(0, 0);
    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
            if (sc.hasNextInt()) {
                int util = sc.nextInt();
                matrix[i][j] = util;
            } else {
                sc.next();
                coord.row = i;
                coord.col = j;
                matrix[i][j] = null;
            }
        }
    }
    sc.close();
    return coord;
}