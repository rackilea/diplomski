// using depth first, then width!!!
private static byte[][] myMap = new byte[10][10];

public static void main(String[] args) {
    move(6, 5, myMap, 0);
}

private static byte[][] cloneMap(byte[][] map) {
    byte[][] newMap = new byte[map.length][];
    for (int x = 0; x < map.length; x++) {
        newMap[x] = map[x].clone();
    }
    return newMap;
}

private static void printMap(byte[][] map) {
    for (int x = 0; x < map.length; x++) {
        for (int y = 0; y < map[0].length; y++) {
            System.out.printf("%3d ", map[x][y] & 0xFF);
        }
        System.out.printf("%n");
    }
}

private static int move(int x, int y, byte[][] map, int i) {
    if (map[x][y] == 0) {
        map[x][y]++;
        i++;
    }
    if (i > 1) return i;

    System.out.printf("x: %d, y: %d%n", x, y);
    // 6 5

    printMap(map);
    System.out.printf("i: %d%n", i);

    // -- note, you may still be missing some way of storing the maps
    map = cloneMap(map);
    i = move(x - 1, y, map, i);

    // System.out.println(map[5][5] + " " + i);
    printMap(map);
    System.out.printf("i: %d%n", i);
    return i;
}