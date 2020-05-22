// three loops
public static void stars(int size) {
    for (int y = 0; y < size; y++) {
        for (int i = 0; i < y && i < size - y - 1; i++)
            System.out.print(' ');
        for (int i = Math.min(y, size - y - 1); i < Math.max(y + 1, size - y); i++)
            System.out.print('*');
        System.out.println();
    }
}