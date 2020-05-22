public static void main(String[] args) {
    int[][][] data = new int[9][3][3];
    for (int x = 0; x < 9; x++)
        for (int y = 0; y < 3; y++)
            for (int z = 0; z < 3; z++)
                data[x][y][z] = 1;
    print(data);

    OUTER: while (true) {
        int x = 8, y = 2, z = 2;
        while (true) {
            if (data[x][y][z] < 9) {
                data[x][y][z]++;
                break;
            }
            data[x][y][z] = 1;
            if (--z < 0) {
                z = 2;
                if (--y < 0) {
                    y = 2;
                    if (--x < 0)
                        break OUTER;
                }
            }
        }
        print(data);
    }
}
private static void print(int[][][] data) {
    for (int x = 0; x < 9; x++)
        for (int y = 0; y < 3; y++)
            for (int z = 0; z < 3; z++)
                System.out.print(data[x][y][z]);
    System.out.println();
}