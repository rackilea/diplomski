// one loop
public static void stars(int size) {
    for (int i = 0; i < size * size; i++) {
        int y = i / size, x = i % size;
        System.out.print(
                (x >= y && x < size - y) ||
                        (x >= size - y - 1 && x <= y) ? '*' : ' ');
        if (x == size - 1)
            System.out.println();
    }
}