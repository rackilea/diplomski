// two loops
public static void stars(int size) {
    for (int y = 0; y < size; y++) {
        for (int x = 0; x < size; x++)
            System.out.print(
                    (x >= y && x < size - y) ||
                            (x >= size - y - 1 && x <= y) ? '*' : ' ');
        System.out.println();
    }
}